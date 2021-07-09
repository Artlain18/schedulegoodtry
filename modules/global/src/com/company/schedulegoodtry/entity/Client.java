package com.company.schedulegoodtry.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Table(name = "SCHEDULEGOODTRY_CLIENT")
@Entity(name = "schedulegoodtry_Client")
@NamePattern("%s %s|fullName,email")
public class Client extends StandardEntity {
    private static final long serialVersionUID = 2967993644035618043L;

    @NotNull
    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @NotNull
    @Column(name = "PHONE_NUMBER", nullable = false, unique = true)
    @Size(min = 11, max = 12)
    @Pattern(regexp = "((\\+7)|8)\\d{10}")
    private String phoneNumber;

    @NotNull
    @Column(name = "EMAIL", nullable = false, unique = true)
    @Email
    private String email;

    @NotNull
    @Column(name = "PASSPORT_NUMBER", nullable = false, unique = true)
    @Size(min = 6, max = 6)
    private String passportNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BANK_ID")
    private Bank bank;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}