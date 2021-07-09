package com.company.schedulegoodtry.web.screens.bank;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedulegoodtry.entity.Bank;

@UiController("schedulegoodtry_Bank.browse")
@UiDescriptor("bank-browse.xml")
@LookupComponent("banksTable")
@LoadDataBeforeShow
public class BankBrowse extends StandardLookup<Bank> {
}