package com.rocky.model;

import java.util.List;


/**
 * Represents a Bill of Lading, which contains shipment details such as shipper, consignee, containers, and route information.
 */
public class BillOfLading {

    /**
     * Unique identifier for the shipment.
     */
    private String shipmentId;

    /**
     * Information about the shipper party.
     */
    private BillofLadingParty shipper;

    /**
     * Information about the consignee party.
     */
    private BillofLadingParty consignee;

    /**
     * List of container IDs associated with the shipment.
     */
    private List<String> containers;

    /**
     * List of trailer IDs associated with the shipment.
     */
    private List<String> trailers;

    /**
     * Indicates whether the shipment is intermodal.
     */
    private boolean intermodal;

    /**
     * The interchange point for the shipment.
     */
    private String interchangePoint;

    /**
     * Route details for the shipment.
     */
    private RouteDetails routeDetails;

    // Getters and setters
    // Constructor

    /**
     * Gets the shipment ID.
     *
     * @return the shipment ID
     */
    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    /**
     * Gets the shipper information.
     *
     * @return the shipper information
     */
    public BillofLadingParty getShipper() {
        return shipper;
    }

    public void setShipper(BillofLadingParty shipper) {
        this.shipper = shipper;
    }

    /**
     * Gets the consignee information.
     *
     * @return the consignee information
     */
    public BillofLadingParty getConsignee() {
        return consignee;
    }

    public void setConsignee(BillofLadingParty consignee) {
        this.consignee = consignee;
    }

    /**
     * Gets the list of container IDs.
     *
     * @return the list of container IDs
     */
    public List<String> getContainers() {
        return containers;
    }

    public void setContainers(List<String> containers) {
        this.containers = containers;
    }

    /**
     * Gets the list of trailer IDs.
     *
     * @return the list of trailer IDs
     */
    public List<String> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<String> trailers) {
        this.trailers = trailers;
    }

    /**
     * Checks if the shipment is intermodal.
     *
     * @return true if the shipment is intermodal, false otherwise
     */
    public boolean isIntermodal() {
        return intermodal;
    }

    public void setIntermodal(boolean intermodal) {
        this.intermodal = intermodal;
    }

    /**
     * Gets the interchange point for the shipment.
     *
     * @return the interchange point
     */
    public String getInterchangePoint() {
        return interchangePoint;
    }

    public void setInterchangePoint(String interchangePoint) {
        this.interchangePoint = interchangePoint;
    }

    /**
     * Gets the route details for the shipment.
     *
     * @return the route details
     */
    public RouteDetails getRouteDetails() {
        return routeDetails;
    }

    public void setRouteDetails(RouteDetails routeDetails) {
        this.routeDetails = routeDetails;
    }

    /**
     * Default constructor.
     */
    public BillOfLading() {
    }

    /**
     * Parameterized constructor to initialize all fields.
     *
     * @param shipmentId       the shipment ID
     * @param shipper          the shipper information
     * @param consignee        the consignee information
     * @param containers       the list of container IDs
     * @param trailers         the list of trailer IDs
     * @param intermodal       whether the shipment is intermodal
     * @param interchangePoint the interchange point
     * @param routeDetails     the route details
     */
    public BillOfLading(String shipmentId, BillofLadingParty shipper, BillofLadingParty consignee, List<String> containers, List<String> trailers, boolean intermodal, String interchangePoint, RouteDetails routeDetails) {
        this.shipmentId = shipmentId;
        this.shipper = shipper;
        this.consignee = consignee;
        this.containers = containers;
        this.trailers = trailers;
        this.intermodal = intermodal;
        this.interchangePoint = interchangePoint;
        this.routeDetails = routeDetails;
    }
}