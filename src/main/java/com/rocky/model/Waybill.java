package com.rocky.model;

import java.util.List;

public class Waybill {
    private String waybillNumber;
    private String shipmentId;
    private WaybillPartyInfo shipper;
    private WaybillPartyInfo consignee;
    private List<String> containers;
    private List<String> trailers;
    private boolean intermodal;
    private String interchangePoint;
    private RouteDetails routeDetails;

    // Getters and setters

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public WaybillPartyInfo getShipper() {
        return shipper;
    }

    public void setShipper(WaybillPartyInfo shipper) {
        this.shipper = shipper;
    }

    public WaybillPartyInfo getConsignee() {
        return consignee;
    }

    public void setConsignee(WaybillPartyInfo consignee) {
        this.consignee = consignee;
    }

    public List<String> getContainers() {
        return containers;
    }

    public void setContainers(List<String> containers) {
        this.containers = containers;
    }

    public List<String> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<String> trailers) {
        this.trailers = trailers;
    }

    public boolean isIntermodal() {
        return intermodal;
    }

    public void setIntermodal(boolean intermodal) {
        this.intermodal = intermodal;
    }

    public String getInterchangePoint() {
        return interchangePoint;
    }

    public void setInterchangePoint(String interchangePoint) {
        this.interchangePoint = interchangePoint;
    }

    public RouteDetails getRouteDetails() {
        return routeDetails;
    }

    public void setRouteDetails(RouteDetails routeDetails) {
        this.routeDetails = routeDetails;
    }

    // Constructor
    public Waybill() {
    }

    public Waybill(String waybillNumber, String shipmentId, WaybillPartyInfo shipper, WaybillPartyInfo consignee, List<String> containers, List<String> trailers, boolean intermodal, String interchangePoint, RouteDetails routeDetails) {
        this.waybillNumber = waybillNumber;
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
