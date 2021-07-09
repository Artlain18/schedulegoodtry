package com.company.schedulegoodtry.web.screens.payment;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedulegoodtry.entity.Payment;

@UiController("schedulegoodtry_Payment.browse")
@UiDescriptor("payment-browse.xml")
@LookupComponent("paymentsTable")
@LoadDataBeforeShow
public class PaymentBrowse extends StandardLookup<Payment> {
}