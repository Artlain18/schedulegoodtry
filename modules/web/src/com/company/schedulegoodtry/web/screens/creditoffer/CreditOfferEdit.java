package com.company.schedulegoodtry.web.screens.creditoffer;

import com.company.schedulegoodtry.entity.CreditOffer;
import com.company.schedulegoodtry.service.CreditOfferService;
import com.haulmont.cuba.gui.components.ValidationErrors;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("schedulegoodtry_CreditOffer.edit")
@UiDescriptor("credit-offer-edit.xml")
@EditedEntityContainer("creditOfferDc")
@LoadDataBeforeShow
public class CreditOfferEdit extends StandardEditor<CreditOffer> {

    @Inject
    private CreditOfferService creditOfferService;

    @Override
    protected void validateAdditionalRules(ValidationErrors errors) {
        if (getEditedEntity().getCreditSum() != null && getEditedEntity().getCredit() != null) {
            if (!(creditOfferService.checkLimit(getEditedEntity().getCreditSum(),
                    getEditedEntity().getCredit()
            ))) {
                errors.add("Сумма кредита превышает лимит по выбранному кредиту");
            }
        }
        super.validateAdditionalRules(errors);
    }
}