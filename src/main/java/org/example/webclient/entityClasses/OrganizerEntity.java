package org.example.webclient.entityClasses;

import jakarta.persistence.*;
import org.example.webclient.domain.modelClasses.OrganizerModel;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "organizer")
public class OrganizerEntity implements Serializable {
    @Id
    @GeneratedValue()
    @Column(name = "id")
    private UUID id;
    @Basic
    @Column(name = "firstname")
    private String firstName;
    @Basic
    @Column(name = "lastname")
    private String lastName;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "address")
    private String address;

    public OrganizerEntity() {

    }

    public OrganizerEntity(OrganizerModel model) {
        setId(model.getId());
        setFirstName(model.getFirstName());
        setLastName(model.getLastName());
        setEmail(model.getEmail());
        setAddress(model.getAddress());
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
