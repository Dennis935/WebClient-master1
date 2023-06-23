package org.example.webclient.entityClasses;

import jakarta.persistence.*;
import org.example.webclient.domain.modelClasses.LocationModel;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "location")
public class LocationEntity implements Serializable {
    @GeneratedValue()
    @Id
    @Column(name = "id")
    private UUID id;
    @Basic
    @Column(name = "location_name")
    private String locationName;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "postalcode")
    private String postalcode;
    @Basic
    @Column(name = "street")
    private String street;
    @Basic
    @Column(name = "house_number")
    private String houseNumber;

    public LocationEntity() {

    }

    public LocationEntity(LocationModel model) {
        setId(model.getId());
        setLocationName(model.getLocationName());
        setCountry(model.getCountry());
        setCity(model.getCity());
        setPostalcode(model.getPostalcode());
        setStreet(model.getStreet());
        setHouseNumber(model.getHouseNumber());
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
