package com.aop.springAOP.controller;

import com.aop.springAOP.dao.AccountDao;
import com.aop.springAOP.dto.Account;
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
    @Autowired
    AccountDao accountDao;

    @GetMapping("/demo")
    public void demo(){
        paymentService.makePayment();
    }
    @GetMapping("/add")
    public void add(){
        paymentService.add();
        paymentService.count();
    }

    @GetMapping("/addAccount")
    public void addAccount(){
        Account accountDao1 = new Account();
       // accountDao.accountDetails(accountDao1.getId(), accountDao1.getName());
        accountDao.findAccounts();

        System.out.println(accountDao.findAccounts());
    }

    @GetMapping("/account")
    public void account(){
        try {
            boolean tripWire = false;
            accountDao.findAccount(tripWire);
        }
        catch (Exception e){
            System.out.println("main program ...caught exception"+e);
        }

    }

}
