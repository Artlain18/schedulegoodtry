package com.company.schedulegoodtry.web.screens.payment;

import com.company.schedulegoodtry.entity.Payment;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.data.TableItems;
import com.haulmont.cuba.gui.components.data.table.ContainerTableItems;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.impl.CollectionContainerImpl;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;
import java.util.List;

@UiController("schedulegoodtry_PaymentSchedule.browse")
@UiDescriptor("payment-schedule-browse.xml")
public class PaymentScheduleBrowse extends Screen {

    @Inject
    private Metadata metadata;

    public void setPayment(List<Payment> payments) {
        @SuppressWarnings("unchecked")
        Table<Payment> paymentsTable = (Table<Payment>) getWindow().getComponentNN("paymentsTable");
        CollectionContainer<Payment> collection = new CollectionContainerImpl<>(metadata.getClassNN(Payment.class));
        TableItems<Payment> tableItems = new ContainerTableItems<>(collection);
        paymentsTable.setItems(tableItems);
        collection.setItems(payments);
    }
}