package com.ch09.controller;

import com.ch09.dto.User1DTO;
import com.ch09.service.User1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
public class User1Controller {

    private final User1Service user1Service;

    @ResponseBody
    @GetMapping("/user1")
    public List<User1DTO> list(){
        List<User1DTO> users = user1Service.selectUser1s();
        return users;
    }

    @ResponseBody
    @GetMapping("/user1/{uid}")
    public User1DTO user(@PathVariable("uid") String uid){
        User1DTO user = user1Service.selectUser1(uid);
        return user;
    }

    @ResponseBody
    @PostMapping("/user1")
    public String register(@RequestBody User1DTO user1DTO){
        log.info(user1DTO);
        user1Service.insertUser1(user1DTO);
        return "/user1/register";
    }

    @PutMapping("/user1")
    public String modify(){
        return "/user1/modify";
    }

    @DeleteMapping("/user1")
    public String delete(){
        return "redirect:/user1/list";
    }


}
