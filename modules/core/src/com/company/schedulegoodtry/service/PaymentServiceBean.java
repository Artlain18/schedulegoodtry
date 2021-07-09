package com.company.schedulegoodtry.service;

import com.company.schedulegoodtry.entity.Payment;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service(PaymentService.NAME)
public class PaymentServiceBean implements PaymentService {


    private final DataManager dataManager;

    PaymentServiceBean(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public Payment createPayment(LocalDateTime setTime, BigDecimal setSumPayment, BigDecimal setSumCreditPayment, BigDecimal setSumPercentPayment) {
        Payment payment = dataManager.create(Payment.class);
        payment.setDatePayment(setTime);
        payment.setSumPayment(setSumPayment);
        payment.setSumCreditPayment(setSumPercentPayment);
        payment.setSumCreditPayment(setSumCreditPayment);

        return payment;
    }
}