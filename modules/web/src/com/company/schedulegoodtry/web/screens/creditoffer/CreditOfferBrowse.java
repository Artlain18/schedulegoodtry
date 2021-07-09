package com.company.schedulegoodtry.web.screens.creditoffer;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedulegoodtry.entity.CreditOffer;

@UiController("schedulegoodtry_CreditOffer.browse")
@UiDescriptor("credit-offer-browse.xml")
@LookupComponent("creditOffersTable")
@LoadDataBeforeShow
public class CreditOfferBrowse extends StandardLookup<CreditOffer> {
}