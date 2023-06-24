package org.example.webclient.dtoClasses;

import org.example.webclient.domain.modelClasses.CustomerModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class CustomerDto implements Serializable {
    private UUID id;
    private String givenName;
    private String familyName;
    private LocalDate birthdate;
    private String address;
    private String creditCardNumber;

    public CustomerDto() {

    }

    public CustomerDto(CustomerModel model) {
        setId(model.getId());
        setGivenName(model.getGivenName());
        setFamilyName(model.getFamilyName());
        setBirthdate(model.getBirthDate());
        setAddress(model.getAddress().getStreetAddress() + " " + model.getAddress().getHouseNumber() +  ", " + model.getAddress().getPostalcode() + " " + model.getAddress().getAddressCountry());
        setCreditCardNumber(model.getCreditCard().getNumber());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
