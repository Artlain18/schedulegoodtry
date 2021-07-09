package com.company.schedulegoodtry.web.screens.payment;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedulegoodtry.entity.Payment;

@UiController("schedulegoodtry_Payment.edit")
@UiDescriptor("payment-edit.xml")
@EditedEntityContainer("paymentDc")
@LoadDataBeforeShow
public class PaymentEdit extends StandardEditor<Payment> {
}