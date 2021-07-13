package com.company.schedulegoodtry.web.screens.creditoffer;

import com.company.schedulegoodtry.service.CreditOfferService;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.screen.*;
import com.company.schedulegoodtry.entity.CreditOffer;

import javax.inject.Inject;

@UiController("schedulegoodtry_CreditOffer.browse")
@UiDescriptor("credit-offer-browse.xml")
@LookupComponent("creditOffersTable")
@LoadDataBeforeShow
public class CreditOfferBrowse extends StandardLookup<CreditOffer> {
    @Inject
    private CreditOfferService creditOfferService;

    private CreditOffer offer;

    @Subscribe("scheduleBtn")
    public void onScheduleBtnClick(Button.ClickEvent event) {
        if (offer != null) {
            creditOfferService.calculateSchedulePayments(offer);
            //Table<CreditOffer> table = (Table<CreditOffer>) getWindow().getComponentNN("creditOffersTable");
            //table.refresh();
        }

    }

    @Subscribe("creditOffersTable")
    public void onCreditOffersTableSelection(Table.SelectionEvent<CreditOffer> event) {
        Button scheduleBtn = (Button) getWindow().getComponentNN("scheduleBtn");
        boolean visible = event.getSelected().size() == 1;
        scheduleBtn.setVisible(visible);
        if (visible) {
            offer = event.getSelected().stream().findFirst().get();
        } else {
            offer = null;
        }
    }
}