package com.example.springdemo.aop.annotation.nouse.ex;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
    public Object loggeerAop(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
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

    public void beforeAdvice(){
        System.out.println("before");
    }
    public void afterAdvice(){
        System.out.println("after");
    }
    public void afterReturningAdvice(){
        System.out.println("after returning");
    }
    public void afterThrowingAdvice() {
        System.out.println("after throwing");
    }
}
