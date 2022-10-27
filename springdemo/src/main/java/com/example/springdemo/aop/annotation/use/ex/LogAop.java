package com.example.springdemo.aop.annotation.use.ex;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {

    @Pointcut("bean(*ker)")
    private void pointcutMethod(){
    }

    @Around("pointcutMethod()")
    public Object logAop(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String signatureStr = proceedingJoinPoint.getSignature().toShortString();
        System.out.println(signatureStr+" is start");
        long st = System.currentTimeMillis();

        try{
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        }finally{
            long et = System.currentTimeMillis();
            System.out.println(signatureStr+" is end, " + (et-st) + " is cost");
        }
    }
}
