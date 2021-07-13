package com.company.schedulegoodtry.service;

import com.company.schedulegoodtry.entity.CreditOffer;
import com.company.schedulegoodtry.entity.Payment;

import java.util.List;

public interface CreditOfferService {
    String NAME = "schedulegoodtry_CreditOfferService";

    List<Payment> calculateSchedulePayments(CreditOffer creditOffer);

    List<Payment> watchSchedulePayments(CreditOffer creditOffer);
}