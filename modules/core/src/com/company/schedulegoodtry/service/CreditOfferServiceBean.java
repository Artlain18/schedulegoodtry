package com.company.schedulegoodtry.service;

import com.company.schedulegoodtry.entity.Credit;
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
        BigDecimal totalMonth = BigDecimal.valueOf(12);
        BigDecimal totalPercent = BigDecimal.valueOf(100);
        BigDecimal i = BigDecimal.valueOf(creditOffer.getCredit().getPercentCredit()).divide((totalPercent.multiply(totalMonth)), MathContext.DECIMAL128);
        //P - monthly payment, S - sum of credit, n - period of credit, i - monthly percent rate, b - yearly percent rate
        // i = b/(100*12) where 100 - totalPercent, 12 - totalMonth
        //P = S * (i + i/[(1+i)^n - 1])
        //In - monthly sum of payment for percent of credit = Sn * i, where Sn - the balance of the loan debt
        //F = P - In, where F - monthly sum of payment for credit
        BigDecimal curSumPayment = creditOffer.getSumCredit().multiply(i.add(i.divide(
                (BigDecimal.valueOf(1).add(i)).pow(creditOffer.getPeriodCredit()).subtract(BigDecimal.valueOf(1)),
                MathContext.DECIMAL128
        )));
        BigDecimal balanceCredit = creditOffer.getSumCredit();
        BigDecimal curSumPercentPayment = balanceCredit.multiply(i);
        BigDecimal curSumCreditPayment = curSumPayment.subtract(curSumPercentPayment);
        List<Payment> curPaymentList = new ArrayList<>();
        Payment firstPayment = paymentService.createPayment(curDate, curSumPayment, curSumCreditPayment, curSumPercentPayment);
        firstPayment.setCreditOffer(creditOffer);
        curPaymentList.add(firstPayment);
        for (int j = 1; j < creditOffer.getPeriodCredit(); j++) {
            Payment curPayment = paymentService.createPayment(curDate, curSumPayment, curSumCreditPayment, curSumPercentPayment);
            balanceCredit = balanceCredit.subtract(curPayment.getSumCreditPayment());
            curSumPercentPayment = balanceCredit.multiply(i);
            curSumCreditPayment = curPayment.getSumPayment().subtract(curSumPercentPayment);
            curDate = curDate.plusMonths(1);
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

    @Override
    public boolean checkLimit(BigDecimal sumCredit, Credit credit) {
        return credit.getLimitCredit().compareTo(sumCredit) >= 0;
    }
}