package org.example.webclient.domain.modelClasses;

import org.example.webclient.entityClasses.CreditCardEntity;

import java.io.Serializable;
import java.util.UUID;

public class CreditCardModel implements Serializable {
    private UUID id;
    private String number;
    private String type;
    private String cvc;

    public CreditCardModel() {

    }

    public CreditCardModel(CreditCardEntity entity) {
        setId(entity.getId());
        setNumber(entity.getNumber());
        setType(entity.getType());
        setCvc(entity.getCvc());
    }

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
