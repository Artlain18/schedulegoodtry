package com.company.schedulegoodtry.web.screens.bank;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedulegoodtry.entity.Bank;

@UiController("schedulegoodtry_Bank.edit")
@UiDescriptor("bank-edit.xml")
@EditedEntityContainer("bankDc")
@LoadDataBeforeShow
public class BankEdit extends StandardEditor<Bank> {
}