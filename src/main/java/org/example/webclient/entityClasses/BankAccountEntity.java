package org.example.webclient.entityClasses;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table (name = "bank_account")
public class BankAccountEntity implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "bank_id")
    private BankEntity bank;
    @Column(name = "iban")
    private String iban;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BankEntity getBank() {
        return bank;
    }

    public void setBank(BankEntity bank) {
        this.bank = bank;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
