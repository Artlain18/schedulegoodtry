package com.company.schedulegoodtry.service;

import com.company.schedulegoodtry.entity.Payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PaymentService {
    String NAME = "schedulegoodtry_PaymentService";

    Payment createPayment(LocalDateTime setTime, BigDecimal setSumPayment, BigDecimal setSumCreditPayment, BigDecimal setSumPercentPayment);
}