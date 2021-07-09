package com.company.schedulegoodtry.web.screens.creditoffer;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedulegoodtry.entity.CreditOffer;

@UiController("schedulegoodtry_CreditOffer.edit")
@UiDescriptor("credit-offer-edit.xml")
@EditedEntityContainer("creditOfferDc")
@LoadDataBeforeShow
public class CreditOfferEdit extends StandardEditor<CreditOffer> {
}