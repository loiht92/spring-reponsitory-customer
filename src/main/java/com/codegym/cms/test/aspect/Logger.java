package com.codegym.cms.test.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {

    @AfterReturning(pointcut = "execution(public * com.codegym.cms.test.service.CustomerService.findAll(..))")
    public void error(){
        System.out.println("Successfully !");
    }
}
