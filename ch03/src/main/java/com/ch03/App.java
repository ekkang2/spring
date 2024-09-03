package com.ch03;

import com.ch03.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 날짜 : 2024/09/03
 * 이름 : 김철학
 * 내용 : 3장 스프링 AOP 실습하기
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MyService service = (MyService) context.getBean("myService");

        service.insert();
        service.select();
        service.update();
        service.delete();

    }
}
