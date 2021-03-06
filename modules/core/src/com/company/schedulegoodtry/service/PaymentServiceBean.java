package com.company.schedulegoodtry.service;

import com.company.schedulegoodtry.entity.Payment;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service(PaymentService.NAME)
public class PaymentServiceBean implements PaymentService {

    @Inject
    private DataManager dataManager;

    @Override
    public Payment createPayment(LocalDateTime setTime,
                                 BigDecimal setSumPayment,
                                 BigDecimal setSumCreditPayment,
                                 BigDecimal setSumPercentPayment
    ) {
        Payment payment = dataManager.create(Payment.class);
        payment.setPaymentDate(setTime);
        payment.setPaymentSum(setSumPayment);
        payment.setPaymentPercentSum(setSumPercentPayment);
        payment.setPaymentCreditSum(setSumCreditPayment);
        return payment;
    }
}