package com.rocky.service;

import com.rocky.model.*;
import com.rocky.publisher.WaybillEventPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WaybillService {

    private static final Logger logger = LoggerFactory.getLogger(WaybillService.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private WaybillEventPublisher waybillEventPublisher;

    public Waybill generateWaybill(BillOfLading bol) {
        String waybillNumber = UUID.randomUUID().toString();
        String status = "CREATED";

        String shipmentMode = determineShipmentMode(bol.getContainers(), bol.getTrailers());
        status += " - " + shipmentMode;

        if (bol.isIntermodal()) {
            status += " - INTERMODAL";
        }

        // Check if Waybill already exists for the shipmentId
        Waybill existingWaybill = getWaybillByShipmentId(bol.getShipmentId());
        Waybill waybill = null;

        if (existingWaybill == null) {
            // If the Waybill does not exist, create a new Waybill with Suspended status
            waybill = createServiceOrder(bol, waybillNumber);
        }

        waybillEventPublisher.publishWaybill(waybill);
        return waybill;
    }

    private Waybill createServiceOrder(BillOfLading bol, String waybillNumber) {
        RouteDetails routeDetails = bol.getRouteDetails();
        WaybillPartyInfo shipper = mapParty(bol.getShipper());
        WaybillPartyInfo consignee = mapParty(bol.getConsignee());

        jdbcTemplate.update(
                "INSERT INTO waybill (waybill_number, shipment_id, " +
                        "shipper_party_name, shipper_party_address, shipper_party_city, shipper_party_state_code, " +
                        "shipper_party_zip_code, shipper_party_country, shipper_party_phone_number, shipper_party_email, " +
                        "shipper_party_tax_id, shipper_party_contact_person, " +
                        "consignee_party_name, consignee_party_address, consignee_party_city, consignee_party_state_code, " +
                        "consignee_party_zip_code, consignee_party_country, consignee_party_phone_number, consignee_party_email, " +
                        "consignee_party_tax_id, consignee_party_contact_person, " +
                        "containers, trailers, intermodal, interchange_point, origin, destination) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                waybillNumber, bol.getShipmentId(),
                shipper.getPartyName(), shipper.getPartyAddress(), shipper.getPartyCity(), shipper.getPartyStateCode(),
                shipper.getPartyZipCode(), shipper.getPartyCountry(), shipper.getPartyPhoneNumber(), shipper.getPartyEmail(),
                shipper.getPartyTaxId(), shipper.getPartyContactPerson(),
                consignee.getPartyName(), consignee.getPartyAddress(), consignee.getPartyCity(), consignee.getPartyStateCode(),
                consignee.getPartyZipCode(), consignee.getPartyCountry(), consignee.getPartyPhoneNumber(), consignee.getPartyEmail(),
                consignee.getPartyTaxId(), consignee.getPartyContactPerson(),
                String.join(",", bol.getContainers()), String.join(",", bol.getTrailers()),
                bol.isIntermodal(), bol.getInterchangePoint(),
                routeDetails.getOrigin(), routeDetails.getDestination()
        );

        logger.info("Waybill generated with number: " + waybillNumber);
        Waybill waybill = new Waybill(
                waybillNumber,
                bol.getShipmentId(),
                shipper,
                consignee,
                bol.getContainers(),
                bol.getTrailers(),
                bol.isIntermodal(),
                bol.getInterchangePoint(),
                routeDetails
        );
        return waybill;
    }

    public Waybill getWaybillByShipmentId(String shipmentId) {

        String sql = "SELECT * FROM waybill WHERE shipment_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{shipmentId}, new WaybillRowMapper());
        } catch (EmptyResultDataAccessException e) {
            logger.error("An error occurred while waybill car by shipmentId: {}", e.getMessage());
            return null; // or return a custom error response, or throw a custom exception
        }
    }

    private String determineShipmentMode(List<String> containers, List<String> trailers) {
        if (containers != null && !containers.isEmpty() && (trailers == null || trailers.isEmpty())) {
            return "COFC"; // Container on Flat Car
        } else if (trailers != null && !trailers.isEmpty() && (containers == null || containers.isEmpty())) {
            return "TOFC"; // Trailer on Flat Car
        } else if ((containers != null && !containers.isEmpty()) && (trailers != null && !trailers.isEmpty())) {
            return "MIXED";
        } else {
            return "UNKNOWN";
        }
    }

    private WaybillPartyInfo mapParty(BillofLadingParty party) {
        return new WaybillPartyInfo(
                party.getPartyName(),
                party.getPartyAddress(),
                party.getPartyCity(),
                party.getPartyStateCode(),
                party.getPartyZipCode(),
                party.getPartyCountry(),
                party.getPartyPhoneNumber(),
                party.getPartyEmail(),
                party.getPartyTaxId(),
                party.getPartyContactPerson()
        );
    }
}
