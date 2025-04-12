package com.rocky.controller;


import com.rocky.model.BillOfLading;
import com.rocky.model.Waybill;
import com.rocky.service.WaybillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * REST controller for handling railroad-related operations.
 */
@RestController
@RequestMapping("/api")
public class RailRoadController {

    private static final Logger logger = LoggerFactory.getLogger(RailRoadController.class);

    @Autowired
    private WaybillService waybillService;

    /**
     * Receives a Bill of Lading and generates a Waybill.
     *
     * @param billOfLading the Bill of Lading object
     * @return the generated Waybill
     */
    @PostMapping("/billoflading")
    public Waybill receiveBillOfLading(@RequestBody BillOfLading billOfLading) {
        return waybillService.generateWaybill(billOfLading);
    }


    /**
     * Retrieves a Waybill by its shipment ID.
     *
     * @param shipmentId the shipment ID
     * @return the Waybill object if found, or a 404 response if not found
     */
    @GetMapping("/waybill/{shipmentId}")
    public ResponseEntity<Waybill> getWaybillByShipmentId(@PathVariable String shipmentId) {
        logger.info("Fetching Waybill for shipmentId={}", shipmentId);
        Waybill waybill = waybillService.getWaybillByShipmentId(shipmentId);
        if (waybill != null) {
            logger.info("Waybill found: waybillNumber={}", waybill.getWaybillNumber());
            return ResponseEntity.ok(waybill);
        } else {
            logger.warn("No Waybill found for shipmentId={}", shipmentId);
            return ResponseEntity.notFound().build();
        }
    }
}