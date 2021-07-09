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
            Payment curPayment = paymentService.createPayment(curDate, curSumPayment, curSumCreditPayment, curSumPercentPayment);
            curPaymentList.add(curPayment);
            balanceCredit = balanceCredit.subtract(curPayment.getSumCreditPayment());
            curSumPercentPayment = balanceCredit.multiply(i);
            curSumCreditPayment = curPayment.getSumPayment().subtract(curSumPercentPayment);
            curPayment.setSumPercentPayment(curSumPercentPayment);
            curPayment.setSumCreditPayment(curSumCreditPayment);
            curPayment.setDatePayment(curDate.plusDays(30));
        }
        creditOffer.setListPayment(curPaymentList);

        return creditOffer;
    }
}