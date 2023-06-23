package org.example.webclient.domain.modelClasses;

import org.example.webclient.entityClasses.LocationEntity;

import java.io.Serializable;
import java.util.UUID;

public class LocationModel implements Serializable {
    private UUID id;
    private String locationName;
    private String country;
    private String city;
    private String postalcode;
    private String street;
    private String houseNumber;

    public LocationModel() {

    }

    public LocationModel(LocationEntity entity) {
        setId(entity.getId());
        setLocationName(entity.getLocationName());
        setCountry(entity.getCountry());
        setCity(entity.getCity());
        setPostalcode(entity.getPostalcode());
        setStreet(entity.getStreet());
        setHouseNumber(entity.getHouseNumber());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}
