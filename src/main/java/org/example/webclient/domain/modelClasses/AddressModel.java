package org.example.webclient.domain.modelClasses;

import org.example.webclient.entityClasses.AddressEntity;

import java.io.Serializable;
import java.util.UUID;

public class AddressModel implements Serializable {
    private UUID id;
    private String addressCountry;
    private String addressLocality;
    private String postalcode;
    private String streetAddress;
    private String houseNumber;

    public AddressModel() {

    }

    public AddressModel(AddressEntity entity) {
        setId(entity.getId());
        setAddressCountry(entity.getAddressCountry());
        setAddressLocality(entity.getAddressLocality());
        setPostalcode(entity.getPostalcode());
        setStreetAddress(entity.getStreetAddress());
        setHouseNumber(entity.getHouseNumber());

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public String getAddressLocality() {
        return addressLocality;
    }

    public void setAddressLocality(String addressLocality) {
        this.addressLocality = addressLocality;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}
