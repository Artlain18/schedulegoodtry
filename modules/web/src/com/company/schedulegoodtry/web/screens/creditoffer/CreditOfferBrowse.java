package com.company.schedulegoodtry.web.screens.creditoffer;

import com.company.schedulegoodtry.entity.CreditOffer;
import com.company.schedulegoodtry.entity.Payment;
import com.company.schedulegoodtry.service.CreditOfferService;
import com.company.schedulegoodtry.web.screens.payment.PaymentScheduleBrowse;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.util.List;

@UiController("schedulegoodtry_CreditOffer.browse")
@UiDescriptor("credit-offer-browse.xml")
@LookupComponent("creditOffersTable")
@LoadDataBeforeShow
public class CreditOfferBrowse extends StandardLookup<CreditOffer> {
    @Inject
    private CreditOfferService creditOfferService;
    @Inject
    private Screens screens;

    private CreditOffer offer;

    @Subscribe("creditOffersTable")
    public void onCreditOffersTableSelection(Table.SelectionEvent<CreditOffer> event) {
        Button checkScheduleBtn = (Button) getWindow().getComponentNN("checkScheduleBtn");
        boolean visible = event.getSelected().size() == 1;
        checkScheduleBtn.setVisible(visible);
        if (visible) {
            offer = event.getSelected().stream().findFirst().get();
        } else {
            offer = null;
        }
    }

    @Subscribe("checkScheduleBtn")
    public void onCheckScheduleBtnClick(Button.ClickEvent event) {
        if (offer != null) {
            List<Payment> payments;
            if (creditOfferService.watchSchedulePayments(offer).isEmpty()) {
                payments = creditOfferService.calculateSchedulePayments(offer);
            } else {
                payments = creditOfferService.watchSchedulePayments(offer);
            }
            PaymentScheduleBrowse creditOfferPaymentsTable = screens.create(PaymentScheduleBrowse.class);
            creditOfferPaymentsTable.setPayment(payments);
            creditOfferPaymentsTable.show();
        }
    }
}