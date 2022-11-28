package com.aop.springAOP.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class MyAspect {


    @Before("execution(* com.aop.springAOP.paymentService.PaymentServiceImpl.makePayment())")
    public void printBefore(){

        System.out.println("Payment started...");
    }
    @After("execution(* com.aop.springAOP.paymentService.PaymentServiceImpl.makePayment())")
    public void printAfter(){
        System.out.println("Payment Done...");
    }
}
