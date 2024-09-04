package com.ch04.controller;

import com.ch04.dto.User1DTO;
import com.ch04.service.User1Service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class User1Controller {

    private User1Service service;

    @Autowired
    public User1Controller(User1Service service) {
        this.service = service;
    }

    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";
    }

    @PostMapping("/user1/register")
    public String register(User1DTO dto){
        System.out.println(dto);

        // 등록
        service.insertUser1(dto);

        // 리다이렉트
        return "redirect:/user1/list";
    }


    @GetMapping("/user1/list")
    public String list(){
        return "/user1/list";
    }
    @GetMapping("/user1/modify")
    public String modify(){
        return "/user1/modify";
    }
    @GetMapping("/user1/delete")
    public String delete(){
        return "/user1/delete";
    }
}
