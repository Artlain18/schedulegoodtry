package com.company.schedulegoodtry.service;

import com.company.schedulegoodtry.entity.CreditOffer;

public interface CreditOfferService {
    String NAME = "schedulegoodtry_CreditOfferService";

    CreditOffer createSchedulePayments(CreditOffer creditOffer);
}