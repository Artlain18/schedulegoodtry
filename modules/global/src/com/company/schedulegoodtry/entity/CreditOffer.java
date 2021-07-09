package com.company.schedulegoodtry.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "SCHEDULEGOODTRY_CREDIT_OFFER")
@Entity(name = "schedulegoodtry_CreditOffer")
public class CreditOffer extends StandardEntity {
    private static final long serialVersionUID = -2100148096608285827L;

    @NotNull
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @NotNull
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CREDIT_ID")
    private Credit credit;

    @NotNull
    @Column(name = "SUM_CREDIT", nullable = false)
    private BigDecimal sumCredit;

    @NotNull
    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @NotNull
    @Column(name = "PERIOD_CREDIT", nullable = false)
    @Positive
    @Min(1)
    @Max(12)
    private Integer periodCredit;

    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "creditOffer")
    private List<Payment> listPayment;

    public List<Payment> getListPayment() {
        return listPayment;
    }

    public void setListPayment(List<Payment> listPayment) {
        this.listPayment = listPayment;
    }

    public Integer getPeriodCredit() {
        return periodCredit;
    }

    public void setPeriodCredit(Integer periodCredit) {
        this.periodCredit = periodCredit;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getSumCredit() {
        return sumCredit;
    }

    public void setSumCredit(BigDecimal sumCredit) {
        this.sumCredit = sumCredit;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}