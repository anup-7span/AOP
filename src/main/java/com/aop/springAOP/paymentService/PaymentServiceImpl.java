package com.aop.springAOP.paymentService;

import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentServiceImpl implements PaymentService{
    @Override
    public void makePayment() {
        System.out.println("amount Debited....");

        System.out.println("Amount Credited...");
    }
}
