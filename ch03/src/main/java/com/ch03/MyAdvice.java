package com.ch03;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// 부가 기능을 갖고 있는 클래스
@Aspect
@Component
public class MyAdvice {

    // 포인트컷
    @Pointcut("execution(void com.ch03.MyService.insert())")
    public void insertPointcut(){}  // 핵심관심을 가리키는 내용이 없는 메서드

    @Pointcut("execution(void com.ch03.MyService.select(..))")  // ..은 모든 매개변수라는 뜻
    public void selectPointcut(){}

    @Before("insertPointcut() || selectPointcut()")
    public void beforeAdvice() {
        System.out.println("부가기능 - beforeAdvice...");
    }

    @After("insertPointcut()")
    public void afterAdvice() {
        System.out.println("부가기능 - afterAdvice...");
    }

    @AfterReturning("insertPointcut()")
    public void afterReturnAdvice() {
        System.out.println("부가기능 - afterReturnAdvice...");
    }

    @Around("insertPointcut()")
    public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("부가기능 - aroundAdvice...1");
        pjp.proceed();  // 핵심기능 실행
        System.out.println("부가기능 - aroundAdvice...2");
    }

    @AfterThrowing("selectPointcut()")
    public void afterThrowAdvice() {
        System.out.println("부가기능 - afterThrowAdvice...");
    }

}
