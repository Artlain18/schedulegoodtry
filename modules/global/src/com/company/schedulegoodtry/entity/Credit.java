package com.company.schedulegoodtry.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.function.Function;

@Table(name = "SCHEDULEGOODTRY_CREDIT")
@Entity(name = "schedulegoodtry_Credit")
@NamePattern("%s %s%%|creditName,creditPercent")
public class Credit extends StandardEntity {
    private static final long serialVersionUID = 5099654559911535654L;

    @NotNull
    @Column(name = "NAME_CREDIT", nullable = false, unique = true)
    private String creditName;

    @NotNull
    @Column(name = "LIMIT_CREDIT", nullable = false)
    @Positive
    private BigDecimal creditLimit;

    @NotNull
    @Column(name = "PERCENT_CREDIT", nullable = false)
    @Positive
    private Double creditPercent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BANK_ID")
    private Bank bank;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Double getCreditPercent() {
        return creditPercent;
    }

    public void setCreditPercent(Double creditPercent) {
        this.creditPercent = creditPercent;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public static class PercentFormatter implements Function<Double, String> {
        @Override
        public String apply(Double percent) {
            return String.valueOf(percent) + '%';
        }
    }
}