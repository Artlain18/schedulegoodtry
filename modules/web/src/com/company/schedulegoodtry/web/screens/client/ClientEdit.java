package com.company.schedulegoodtry.web.screens.client;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedulegoodtry.entity.Client;

@UiController("schedulegoodtry_Client.edit")
@UiDescriptor("client-edit.xml")
@EditedEntityContainer("clientDc")
@LoadDataBeforeShow
public class ClientEdit extends StandardEditor<Client> {
}