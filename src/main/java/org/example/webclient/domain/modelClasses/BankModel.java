package org.example.webclient.domain.modelClasses;

import org.example.webclient.entityClasses.BankEntity;

import java.io.Serializable;
import java.util.UUID;

public class BankModel implements Serializable {
    private UUID id;
    private String city;
    private String bankcode;
    private String description;
    private String bic;

    public BankModel() {

    }

    public BankModel(BankEntity entity) {
        setId(entity.getId());
        setCity(entity.getCity());
        setBankcode(entity.getBankCode());
        setDescription(entity.getDescription());
        setBic(entity.getBic());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }
}
