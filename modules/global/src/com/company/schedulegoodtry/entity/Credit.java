package com.company.schedulegoodtry.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Table(name = "SCHEDULEGOODTRY_CREDIT")
@Entity(name = "schedulegoodtry_Credit")
public class Credit extends StandardEntity {
    private static final long serialVersionUID = 5099654559911535654L;

    @NotNull
    @Column(name = "NAME_CREDIT", nullable = false, unique = true)
    private String nameCredit;

    @NotNull
    @Column(name = "LIMIT_CREDIT", nullable = false)
    @Positive
    private BigDecimal limitCredit;

    @NotNull
    @Column(name = "PERCENT_CREDIT", nullable = false)
    @Positive
    private Double percentCredit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BANK_ID")
    private Bank bank;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Double getPercentCredit() {
        return percentCredit;
    }

    public void setPercentCredit(Double percentCredit) {
        this.percentCredit = percentCredit;
    }

    public BigDecimal getLimitCredit() {
        return limitCredit;
    }

    public void setLimitCredit(BigDecimal limitCredit) {
        this.limitCredit = limitCredit;
    }

    public String getNameCredit() {
        return nameCredit;
    }

    public void setNameCredit(String nameCredit) {
        this.nameCredit = nameCredit;
    }
}