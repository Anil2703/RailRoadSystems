package com.rocky;

import com.rocky.model.BillOfLading;
import com.rocky.model.BillofLadingParty;
import com.rocky.model.RouteDetails;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BillOfLadingTest {

    @Test
    void testGettersAndSetters() {
        BillOfLading billOfLading = new BillOfLading();

        billOfLading.setShipmentId("SHIP123");
        assertEquals("SHIP123", billOfLading.getShipmentId());

        BillofLadingParty shipper = new BillofLadingParty("ShipperName", "ShipperAddress", "City", "State", "12345", "Country", "1234567890", "shipper@example.com", "TAX123", "ContactPerson");
        billOfLading.setShipper(shipper);
        assertEquals(shipper, billOfLading.getShipper());

        BillofLadingParty consignee = new BillofLadingParty("ConsigneeName", "ConsigneeAddress", "City", "State", "54321", "Country", "0987654321", "consignee@example.com", "TAX321", "ContactPerson");
        billOfLading.setConsignee(consignee);
        assertEquals(consignee, billOfLading.getConsignee());

        List<String> containers = Arrays.asList("CONT1", "CONT2");
        billOfLading.setContainers(containers);
        assertEquals(containers, billOfLading.getContainers());

        List<String> trailers = Arrays.asList("TRAIL1", "TRAIL2");
        billOfLading.setTrailers(trailers);
        assertEquals(trailers, billOfLading.getTrailers());

        billOfLading.setIntermodal(true);
        assertTrue(billOfLading.isIntermodal());

        billOfLading.setInterchangePoint("PointA");
        assertEquals("PointA", billOfLading.getInterchangePoint());

        RouteDetails routeDetails = new RouteDetails("Origin", "Destination");
        billOfLading.setRouteDetails(routeDetails);
        assertEquals(routeDetails, billOfLading.getRouteDetails());
    }

    @Test
    void testParameterizedConstructor() {
        BillofLadingParty shipper = new BillofLadingParty("ShipperName", "ShipperAddress", "City", "State", "12345", "Country", "1234567890", "shipper@example.com", "TAX123", "ContactPerson");
        BillofLadingParty consignee = new BillofLadingParty("ConsigneeName", "ConsigneeAddress", "City", "State", "54321", "Country", "0987654321", "consignee@example.com", "TAX321", "ContactPerson");
        List<String> containers = Arrays.asList("CONT1", "CONT2");
        List<String> trailers = Arrays.asList("TRAIL1", "TRAIL2");
        RouteDetails routeDetails = new RouteDetails("Origin", "Destination");

        BillOfLading billOfLading = new BillOfLading("SHIP123", shipper, consignee, containers, trailers, true, "PointA", routeDetails);

        assertEquals("SHIP123", billOfLading.getShipmentId());
        assertEquals(shipper, billOfLading.getShipper());
        assertEquals(consignee, billOfLading.getConsignee());
        assertEquals(containers, billOfLading.getContainers());
        assertEquals(trailers, billOfLading.getTrailers());
        assertTrue(billOfLading.isIntermodal());
        assertEquals("PointA", billOfLading.getInterchangePoint());
        assertEquals(routeDetails, billOfLading.getRouteDetails());
    }
}