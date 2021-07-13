package com.company.schedulegoodtry.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "SCHEDULEGOODTRY_PAYMENT")
@Entity(name = "schedulegoodtry_Payment")
@NamePattern("%s %s %s %s|datePayment,sumPayment,sumCreditPayment,sumPercentPayment")
public class Payment extends StandardEntity {
    private static final long serialVersionUID = -9179147032951807207L;

    @NotNull
    @Column(name = "DATE_PAYMENT", nullable = false)
    private LocalDateTime datePayment;

    @NotNull
    @Column(name = "SUM_PAYMENT", nullable = false)
    @Positive
    private BigDecimal sumPayment;

    @NotNull
    @Column(name = "SUM_CREDIT_PAYMENT", nullable = false)
    @Positive
    private BigDecimal sumCreditPayment;

    @NotNull
    @Column(name = "SUM_PERCENT_PAYMENT", nullable = false)
    @Positive
    private BigDecimal sumPercentPayment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREDIT_OFFER_ID")
    private CreditOffer creditOffer;

    public CreditOffer getCreditOffer() {
        return creditOffer;
    }

    public void setCreditOffer(CreditOffer creditOffer) {
        this.creditOffer = creditOffer;
    }

    public BigDecimal getSumPercentPayment() {
        return sumPercentPayment;
    }

    public void setSumPercentPayment(BigDecimal sumPercentPayment) {
        this.sumPercentPayment = sumPercentPayment;
    }

    public BigDecimal getSumCreditPayment() {
        return sumCreditPayment;
    }

    public void setSumCreditPayment(BigDecimal sumCreditPayment) {
        this.sumCreditPayment = sumCreditPayment;
    }

    public BigDecimal getSumPayment() {
        return sumPayment;
    }

    public void setSumPayment(BigDecimal sumPayment) {
        this.sumPayment = sumPayment;
    }

    public LocalDateTime getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(LocalDateTime datePayment) {
        this.datePayment = datePayment;
    }
}