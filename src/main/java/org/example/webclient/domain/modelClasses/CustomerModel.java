package org.example.webclient.domain.modelClasses;

import org.example.webclient.entityClasses.CustomerEntity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class CustomerModel implements Serializable {
    private UUID id;
    private String givenName;
    private String familyName;
    private String birthName;
    private String gender;
    private LocalDate birthDate;
    private int height;
    private String eyecolor;
    private String email;
    private String taxId;
    private AddressModel address;
    private String phoneNo;
    private String mobileNo;
    private BankAccountModel bankAccount;
    private CreditCardModel creditCard;

    public CustomerModel() {

    }

    public CustomerModel(CustomerEntity entity) {
        setId(entity.getId());
        setGivenName(entity.getGivenName());
        setFamilyName(entity.getFamilyName());
        setBirthName(entity.getBirthName());
        setGender(entity.getGender());
        setBirthDate(entity.getBirthDate());
        setHeight(entity.getHeight());
        setEyecolor(entity.getEyecolor());
        setEmail(entity.getEmail());
        setTaxId(entity.getTaxId());
        setAddress(new AddressModel(entity.getAddress()));
        setPhoneNo(entity.getPhoneNo());
        setMobileNo(entity.getMobileNo());
        setBankAccount(new BankAccountModel(entity.getBankAccount()));
        setCreditCard(new CreditCardModel(entity.getCreditCard()));
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getBirthName() {
        return birthName;
    }

    public void setBirthName(String birthName) {
        this.birthName = birthName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getEyecolor() {
        return eyecolor;
    }

    public void setEyecolor(String eyecolor) {
        this.eyecolor = eyecolor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public BankAccountModel getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccountModel bankAccount) {
        this.bankAccount = bankAccount;
    }

    public CreditCardModel getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCardModel creditCard) {
        this.creditCard = creditCard;
    }

}
