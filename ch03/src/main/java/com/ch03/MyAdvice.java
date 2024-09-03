package com.ch03;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice {

    // 포인트컷
    @Pointcut("execution(void com.ch03.MyService.insert())")
    public void insertPointcut(){} // 핵심관심을 가리키는 내용이 없는 메서드
    
    @Before("insertPointcut()")
    public void beforeAdvice(){
        System.out.println("부가기능 - beforeAdvice...");
    }

    public void afterAdvice(){
        System.out.println("부가기능 - afterAdvice...");
    }
    public void afterReturnAdvice(){
        System.out.println("부가기능 - afterReturnAdvice...");
    }
    public void aroundAdvice(){
        System.out.println("부가기능 - aroundAdvice...");
    }
    public void afterThrowAdvice(){
        System.out.println("부가기능 - afterThrowAdvice...");
    }
}
