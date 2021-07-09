package com.company.schedulegoodtry.service;

import com.company.schedulegoodtry.entity.Payment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service(PaymentService.NAME)
public class PaymentServiceBean implements PaymentService {

    @Override
    public Payment createPayment(LocalDateTime setTime, BigDecimal setSumPayment, BigDecimal setSumCreditPayment, BigDecimal setSumPercentPayment) {
        Payment payment = new Payment(setTime, setSumPayment, setSumCreditPayment, setSumPercentPayment);
        return payment;
    }
}