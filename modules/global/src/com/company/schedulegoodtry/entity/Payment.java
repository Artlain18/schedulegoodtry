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
@NamePattern("%s %s %s %s|paymentDate,paymentSum,paymentCreditSum,paymentPercentSum")
public class Payment extends StandardEntity implements Comparable<Payment> {
    private static final long serialVersionUID = -9179147032951807207L;

    @NotNull
    @Column(name = "DATE_PAYMENT", nullable = false)
    private LocalDateTime paymentDate;

    @NotNull
    @Column(name = "SUM_PAYMENT", nullable = false)
    @Positive
    private BigDecimal paymentSum;

    @NotNull
    @Column(name = "SUM_CREDIT_PAYMENT", nullable = false)
    @Positive
    private BigDecimal paymentCreditSum;

    @NotNull
    @Column(name = "SUM_PERCENT_PAYMENT", nullable = false)
    @Positive
    private BigDecimal paymentPercentSum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREDIT_OFFER_ID")
    private CreditOffer creditOffer;

    public CreditOffer getCreditOffer() {
        return creditOffer;
    }

    public void setCreditOffer(CreditOffer creditOffer) {
        this.creditOffer = creditOffer;
    }

    public BigDecimal getPaymentPercentSum() {
        return paymentPercentSum;
    }

    public void setPaymentPercentSum(BigDecimal paymentPercentSum) {
        this.paymentPercentSum = paymentPercentSum;
    }

    public BigDecimal getPaymentCreditSum() {
        return paymentCreditSum;
    }

    public void setPaymentCreditSum(BigDecimal paymentCreditSum) {
        this.paymentCreditSum = paymentCreditSum;
    }

    public BigDecimal getPaymentSum() {
        return paymentSum;
    }

    public void setPaymentSum(BigDecimal paymentSum) {
        this.paymentSum = paymentSum;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public int compareTo(Payment payment) {
        return getPaymentDate().compareTo(payment.getPaymentDate());
    }
}