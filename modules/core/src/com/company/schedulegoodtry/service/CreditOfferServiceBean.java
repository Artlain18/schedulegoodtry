package com.company.schedulegoodtry.service;

import com.company.schedulegoodtry.entity.CreditOffer;
import com.company.schedulegoodtry.entity.Payment;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service(CreditOfferService.NAME)
public class CreditOfferServiceBean implements CreditOfferService {

    private final DataManager dataManager;
    private final PaymentService paymentService;

    @Inject
    CreditOfferServiceBean(
            PaymentService paymentService,
            DataManager dataManager
    ) {
        this.paymentService = paymentService;
        this.dataManager = dataManager;
    }

    @Override
    public List<Payment> calculateSchedulePayments(CreditOffer creditOffer) {
        LocalDateTime curDate = creditOffer.getStartDate();
        BigDecimal i = BigDecimal.valueOf(creditOffer.getCredit().getPercentCredit()).divide(BigDecimal.valueOf(1200), MathContext.DECIMAL128);
        BigDecimal curSumPayment = creditOffer.getSumCredit().multiply(i.add(i.divide(
                (BigDecimal.valueOf(1).add(i)).pow(creditOffer.getPeriodCredit()).subtract(BigDecimal.valueOf(1)),
                MathContext.DECIMAL128
        )));
        BigDecimal balanceCredit = creditOffer.getSumCredit();
        BigDecimal curSumPercentPayment = balanceCredit.multiply(i); //погашение процента
        BigDecimal curSumCreditPayment = curSumPayment.subtract(curSumPercentPayment); // погашение кредита
        List<Payment> curPaymentList = new ArrayList<>();
        Payment firstPayment = paymentService.createPayment(curDate, curSumPayment, curSumCreditPayment, curSumPercentPayment);
        firstPayment.setCreditOffer(creditOffer);
        curPaymentList.add(firstPayment);
        for (int j = 1; j < creditOffer.getPeriodCredit(); j++) {
            Payment curPayment = paymentService.createPayment(curDate, curSumPayment, curSumCreditPayment, curSumPercentPayment);
            balanceCredit = balanceCredit.subtract(curPayment.getSumCreditPayment());
            curSumPercentPayment = balanceCredit.multiply(i);
            curSumCreditPayment = curPayment.getSumPayment().subtract(curSumPercentPayment);
            curDate = curDate.plusDays(30);
            curPayment.setSumPercentPayment(curSumPercentPayment);
            curPayment.setSumCreditPayment(curSumCreditPayment);
            curPayment.setDatePayment(curDate);
            curPayment.setCreditOffer(creditOffer);
            curPaymentList.add(curPayment);
        }
        creditOffer.setListPayment(curPaymentList);
        dataManager.commit(creditOffer);
        return curPaymentList;
    }

    @Override
    public List<Payment> watchSchedulePayments(CreditOffer creditOffer) {
        List<Payment> payments = creditOffer.getListPayment();
        Collections.sort(payments);
        return payments;
    }
}