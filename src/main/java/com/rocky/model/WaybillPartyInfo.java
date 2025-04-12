package com.rocky.model;

public class WaybillPartyInfo {
    private String partyName;
    private String partyAddress;
    private String partyCity;
    private String partyStateCode;
    private String partyZipCode;
    private String partyCountry;
    private String partyPhoneNumber;
    private String partyEmail;
    private String partyTaxId;
    private String partyContactPerson;

    // Getters and setters

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartyAddress() {
        return partyAddress;
    }

    public void setPartyAddress(String partyAddress) {
        this.partyAddress = partyAddress;
    }

    public String getPartyCity() {
        return partyCity;
    }

    public void setPartyCity(String partyCity) {
        this.partyCity = partyCity;
    }

    public String getPartyStateCode() {
        return partyStateCode;
    }

    public void setPartyStateCode(String partyStateCode) {
        this.partyStateCode = partyStateCode;
    }

    public String getPartyZipCode() {
        return partyZipCode;
    }

    public void setPartyZipCode(String partyZipCode) {
        this.partyZipCode = partyZipCode;
    }

    public String getPartyCountry() {
        return partyCountry;
    }

    public void setPartyCountry(String partyCountry) {
        this.partyCountry = partyCountry;
    }

    public String getPartyPhoneNumber() {
        return partyPhoneNumber;
    }

    public void setPartyPhoneNumber(String partyPhoneNumber) {
        this.partyPhoneNumber = partyPhoneNumber;
    }

    public String getPartyEmail() {
        return partyEmail;
    }

    public void setPartyEmail(String partyEmail) {
        this.partyEmail = partyEmail;
    }

    public String getPartyTaxId() {
        return partyTaxId;
    }

    public void setPartyTaxId(String partyTaxId) {
        this.partyTaxId = partyTaxId;
    }

    public String getPartyContactPerson() {
        return partyContactPerson;
    }

    public void setPartyContactPerson(String partyContactPerson) {
        this.partyContactPerson = partyContactPerson;
    }

    // Constructor
    public WaybillPartyInfo() {
    }

    public WaybillPartyInfo(String partyName, String partyAddress, String partyCity, String partyStateCode, String partyZipCode, String partyCountry, String partyPhoneNumber, String partyEmail, String partyTaxId, String partyContactPerson) {
        this.partyName = partyName;
        this.partyAddress = partyAddress;
        this.partyCity = partyCity;
        this.partyStateCode = partyStateCode;
        this.partyZipCode = partyZipCode;
        this.partyCountry = partyCountry;
        this.partyPhoneNumber = partyPhoneNumber;
        this.partyEmail = partyEmail;
        this.partyTaxId = partyTaxId;
        this.partyContactPerson = partyContactPerson;
    }
}
