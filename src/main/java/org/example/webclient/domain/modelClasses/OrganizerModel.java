package org.example.webclient.domain.modelClasses;

import org.example.webclient.entityClasses.OrganizerEntity;

import java.io.Serializable;
import java.util.UUID;

public class OrganizerModel implements Serializable {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;


    public OrganizerModel() {

    }

    public OrganizerModel(OrganizerEntity entity) {
        setId(entity.getId());
        setFirstName(entity.getFirstName());
        setLastName(entity.getLastName());
        setEmail(entity.getEmail());
        setAddress(entity.getAddress());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
