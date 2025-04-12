package com.rocky.model;

public class RouteDetails {
    private String origin;
    private String destination;

    public RouteDetails() {}

    public RouteDetails(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    // Getters and Setters

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}