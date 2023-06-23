package org.example.webclient.entityClasses;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table (name = "bank")
public class BankEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;
    @Column(name = "city")
    private String city;
    @Column (name = "bankCode")
    private String bankCode;
    @Column (name = "description")
    private String description;
    @Column (name = "bic")
    private String bic;

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

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
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
