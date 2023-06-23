package org.example.webclient.entityClasses;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table (name = "credit_card")
public class CreditCardEntity implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "number")
    private String number;
    @Column (name = "type")
    private String type;
    @Column (name = "cvc")
    private String cvc;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
}
