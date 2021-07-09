package com.company.schedulegoodtry.web.screens.credit;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedulegoodtry.entity.Credit;

@UiController("schedulegoodtry_Credit.edit")
@UiDescriptor("credit-edit.xml")
@EditedEntityContainer("creditDc")
@LoadDataBeforeShow
public class CreditEdit extends StandardEditor<Credit> {
}