package com.company.schedulegoodtry.service;

import com.company.schedulegoodtry.entity.CreditOffer;
import com.company.schedulegoodtry.entity.Payment;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service(CreditOfferService.NAME)
public class CreditOfferServiceBean implements CreditOfferService {

    @Inject
    private PaymentService paymentService;

    @Override
    public CreditOffer createSchedulePayments(CreditOffer creditOffer) {
        LocalDateTime curDate = creditOffer.getStartDate();

        BigDecimal i = BigDecimal.valueOf(creditOffer.getCredit().getPercentCredit()).divide(BigDecimal.valueOf(1200), MathContext.DECIMAL128);
        BigDecimal curSumPayment = creditOffer.getSumCredit().multiply(i.add(i.divide(
                (BigDecimal.valueOf(1).add(i)).pow(creditOffer.getPeriodCredit()).subtract(BigDecimal.valueOf(1)),
                MathContext.DECIMAL128
        )));
        //BigDecimal curSumPayment = convertToBigDec(p);//постоянная сумма платежа
        BigDecimal balanceCredit = creditOffer.getSumCredit();
        BigDecimal curSumPercentPayment = balanceCredit.multiply(i); //погашение процента

        BigDecimal curSumCreditPayment = curSumPayment.subtract(curSumPercentPayment); // погашение кредита
        //BigDecimal curSumPercentPayment = convertToBigDec(h);
        //BigDecimal curSumCreditPayment = convertToBigDec(s);


        List<Payment> curPaymentList = new ArrayList<>();
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