package com.aop.springAOP.dao;

import com.aop.springAOP.dto.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDao {

    public void accountDetails(int id, String name) {
    Account accountDao = new Account(1,"anup");
    accountDao.setId(1);
    accountDao.setName("anup");
        System.out.println("Id:-"+accountDao.getId());
        System.out.println("Name:-"+accountDao.getName());

    }
    public List<Account> findAccounts(){
        List<Account>myAccount = new ArrayList<>();

        Account a1= new Account(1,"anup");
        Account a2= new Account(2,"harsh");
        Account a3= new Account(3,"hetvi");

        myAccount.add(a1);
        myAccount.add(a2);
        myAccount.add(a3);
        return myAccount;
    }

    public List<Account> findAccount(boolean tripWire){

        if (tripWire = true){
            throw new RuntimeException("No soup for you");
        }

        List<Account>myAccount = new ArrayList<>();

        Account a1= new Account(1,"anup");
        Account a2= new Account(2,"harsh");
        Account a3= new Account(3,"hetvi");

        myAccount.add(a1);
        myAccount.add(a2);
        myAccount.add(a3);
        return myAccount;
    }
}
