package com.company.schedulegoodtry.web.screens.credit;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedulegoodtry.entity.Credit;

@UiController("schedulegoodtry_Credit.browse")
@UiDescriptor("credit-browse.xml")
@LookupComponent("creditsTable")
@LoadDataBeforeShow
public class CreditBrowse extends StandardLookup<Credit> {
}