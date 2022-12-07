package com.aop.springAOP.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

/*//execute before methode call
    @Before("execution(* com.aop.springAOP.paymentService.PaymentServiceImpl.makePayment())")
    public void printBefore(JoinPoint joinPoint){

        System.out.println("Payment started...");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method Signature :->"+signature);
    }*/
/*//execute before void add methode
    @Before("execution(public void add())")
    public void beforeAdd(){
        System.out.println("Adding new records");
    }
//execute before methode start with add
    @Before("execution(public void add*())")
    public void addBefore(){
        System.out.println("before Add.......");
    }

    //execute return type is void
    @Before("execution(void add*())")
    public void returnIsVoid(){
        System.out.println("Return type is void.......");
    }*/


//pointcut declaration

    @Pointcut("execution(* com.aop.springAOP.paymentService.PaymentServiceImpl.*())")
    public void pointcutDemo(){}

/*
    @Before("pointcutDemo()")
    public void getPointcut(){
        System.out.println("pointcut demo.........");
    }

    @Before("pointcutDemo()")
    public void getPointcut2(){
        System.out.println("pointcut demo2......****");
    }
*/
    //combining pointcut

    //pointcut for add method
    @Pointcut("execution(* com.aop.springAOP.paymentService.PaymentServiceImpl.add())")
    public void add(){}
    @Pointcut("execution(* com.aop.springAOP.paymentService.PaymentServiceImpl.count())")
    public void count(){}

    //pointcut include package.. exclude add/count
    @Pointcut("pointcutDemo() && (add() || count())")
    public void combiningPointcut(){}

/*    @Before("combiningPointcut()")
    public void getCombiningPointcut(){
        System.out.println("combining pointcut demo First.........");
    }*/

    @Before("combiningPointcut()")
    public void getCombiningPointcutSecond(){
        System.out.println("combining pointcut demo Second.........");
    }
/*    @Before("combiningPointcut()")
    private void getCombiningPointcutTheard(){
        System.out.println("combining pointcut demo Theard.........");
    }*/



    @After("execution(* com.aop.springAOP.paymentService.PaymentServiceImpl.makePayment())")
    public void printAfter()
    {
        System.out.println("Payment Done...");
    }

}