package com.ch03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 클래스명(myService)이 생략되어 있는거임 **소문자로 시작
public class MyService {


    public void insert(){
        System.out.println("핵심기능 - insert...");
    }

    public void select(String uid){
        System.out.println("핵심기능 - select...");

        if (uid.equals("a101")) {
            System.out.println("핵심기능 - uid : " + uid);
        }
    }

    public void update(){
        System.out.println("핵심기능 - update...");
    }

    public void delete(){
        System.out.println("핵심기능 - delete...");
    }




}
