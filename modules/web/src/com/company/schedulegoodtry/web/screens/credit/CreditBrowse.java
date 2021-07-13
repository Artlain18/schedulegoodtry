package com.company.schedulegoodtry.web.screens.credit;

import com.company.schedulegoodtry.entity.Credit;
import com.haulmont.cuba.gui.screen.*;

@UiController("schedulegoodtry_Credit.browse")
@UiDescriptor("credit-browse.xml")
@LookupComponent("creditsTable")
@LoadDataBeforeShow
public class CreditBrowse extends StandardLookup<Credit> {
}