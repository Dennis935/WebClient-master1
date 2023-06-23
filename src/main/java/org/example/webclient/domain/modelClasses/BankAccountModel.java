package org.example.webclient.domain.modelClasses;

import org.example.webclient.entityClasses.BankAccountEntity;

import java.io.Serializable;
import java.util.UUID;

public class BankAccountModel implements Serializable {
    private UUID id;
    private BankModel bank;
    private String iban;

    public BankAccountModel() {

    }

    public BankAccountModel(BankAccountEntity entity) {
        setId(entity.getId());
        setBank(new BankModel(entity.getBank()));
        setIban(entity.getIban());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BankModel getBank() {
        return bank;
    }

    public void setBank(BankModel bank) {
        this.bank = bank;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
