package com.company.schedulegoodtry.web.screens.client;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedulegoodtry.entity.Client;

@UiController("schedulegoodtry_Client.browse")
@UiDescriptor("client-browse.xml")
@LookupComponent("clientsTable")
@LoadDataBeforeShow
public class ClientBrowse extends StandardLookup<Client> {
}