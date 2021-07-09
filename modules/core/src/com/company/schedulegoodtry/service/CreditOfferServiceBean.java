package com.company.schedulegoodtry.service;

import com.company.schedulegoodtry.entity.CreditOffer;
import com.company.schedulegoodtry.entity.Payment;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;

@Service(CreditOfferService.NAME)
public class CreditOfferServiceBean implements CreditOfferService {

    @Inject
    private PaymentService paymentService;

    @Override
    public CreditOffer createSchedulePayments(CreditOffer creditOffer) {
        LocalDateTime curDate = creditOffer.getStartDate();

        Double i = creditOffer.getCredit().getPercentCredit() / 1200;
        Double p = creditOffer.getSumCredit().doubleValue() * (i + i / (Math.pow(1 + i, creditOffer.getPeriodCredit()) - 1));
        BigDecimal curSumPayment = convertToBigDec(p);//постоянная сумма платежа
        Double balanceCredit = creditOffer.getSumCredit().doubleValue();
        Double h = balanceCredit * i; //погашение процента
        Double s = curSumPayment.doubleValue() - h; // погашение кредита
        BigDecimal curSumPercentPayment = convertToBigDec(h);
        BigDecimal curSumCreditPayment = convertToBigDec(s);

        Payment setPayment = paymentService.createPayment(curDate, curSumPayment, curSumCreditPayment, curSumPercentPayment);
        for (int j = 0; j < creditOffer.getPeriodCredit(); j++) {
            creditOffer.getListPayment().add(setPayment);
            balanceCredit = balanceCredit - s;
            h = balanceCredit * i;
            curSumPercentPayment = convertToBigDec(h);
            curSumCreditPayment = convertToBigDec(curSumPayment.doubleValue() - curSumPercentPayment.doubleValue());
            setPayment.setSumPercentPayment(curSumPercentPayment);
            setPayment.setSumCreditPayment(curSumCreditPayment);
            setPayment.setDatePayment(curDate.plusDays(30));
        }
        return creditOffer;
    }
    public BigDecimal convertToBigDec(Double a) {
        BigDecimal b = new BigDecimal(a, MathContext.DECIMAL64);
        return b;
    }
}