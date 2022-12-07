package com.aop.springAOP.aspect;

import com.aop.springAOP.dto.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class NewMyAspect {

//After throwing
    @AfterThrowing(
            pointcut="execution(* com.aop.springAOP.dao.AccountDao.findAccount(..))",
            throwing = "theExc")
    public void afterThrowingFindAccount(JoinPoint joinPoint, Throwable theExc){
        String method = joinPoint.getSignature().toShortString();

        System.out.println("\n====> Execution  @AfterThrowing on method"+method);

        System.out.println("\n====> Execution  result is"+theExc);

    }

    //using of After returning
    @AfterReturning(
            pointcut="execution(* com.aop.springAOP.dao.AccountDao.findAccount(..))",
            returning = "result")
    public void afterReturningFindAccount(JoinPoint joinPoint, List<Account> result){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====> Execution  @AfterReturning on method"+method);

        System.out.println("\n====> Execution  result is"+result);

        //convert account name to upper case
        convertAccountNameToUpperCase(result);
        System.out.println("\n====> result is :-"+result);
    }

    private void convertAccountNameToUpperCase(List<Account> result) {

        for (Account account :result){
            String theUpperName = account.getName().toUpperCase();
            account.setName(theUpperName);
        }
    }


  /*  //Ordering Aspect
    @Before("com.aop.springAOP.aspect.MyAspect.combiningPointcut()")
    public void getCombiningPointcut(JoinPoint joinPoint){
        System.out.println("combining pointcut demo First.........");

        //display methode signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method:-"+methodSignature);

    }
    @Before("execution(public void accountDetails(..))")
    public void adAccount(JoinPoint joinPoint){
        //display method argument

        Object[] args = joinPoint.getArgs();
        for (Object temp:args) {
            System.out.println(temp);
            if (temp instanceof AccountDao){
                Account accountDao= (Account) temp;
                System.out.println("account id:-"+accountDao.getId());
                System.out.println("account name:-"+accountDao.getName());
            }
        }
    }*/
}
