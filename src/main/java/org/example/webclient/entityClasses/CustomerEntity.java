package org.example.webclient.entityClasses;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table (name = "customer")
public class CustomerEntity implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "given_name")
    private String givenName;
    @Column (name = "family_name")
    private String familyName;
    @Column (name = "birth_name")
    private String birthName;
    @Column (name = "gender")
    private String gender;
    @Column (name = "birthDate")
    private LocalDate birthDate;
    @Column (name = "height")
    private int height;
    @Column (name = "eyecolor")
    private String eyecolor;
    @Column (name = "email")
    private String email;
    @Column (name = "tax_id")
    private String taxId;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;
    @Column (name = "phone_no")
    private String phoneNo;
    @Column (name = "mobile_no")
    private String mobileNo;
    @ManyToOne
    @JoinColumn (name = "bank_account_id")
    private BankAccountEntity bankAccount;
    @ManyToOne
    @JoinColumn (name = "credit_card_id")
    private CreditCardEntity creditCard;

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

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
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

    public BankAccountEntity getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccountEntity bankAccount) {
        this.bankAccount = bankAccount;
    }

    public CreditCardEntity getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCardEntity creditCard) {
        this.creditCard = creditCard;
    }

}
