package com.aop.springAOP;


import com.aop.springAOP.dao.AccountDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.AccessibleObject;

@SpringBootApplication
public class SpringAopApplication {
	public static void main(String[] args) {
				SpringApplication.run(SpringAopApplication.class, args);}

}
