package com.aop.springAOP.controller;

import com.aop.springAOP.paymentService.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class controller {
    @Autowired
    PaymentService paymentService;

    @GetMapping("/demo")
    public void demo(){
        paymentService.makePayment();
    }
}
