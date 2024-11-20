package co.kr.ekkang.controller;

import co.kr.ekkang.dto.UserDTO;
import co.kr.ekkang.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;


    @GetMapping
    public ResponseEntity login(){
        return null;
    }


    @PostMapping("/user")
    public ResponseEntity register(@RequestBody UserDTO userDTO) {

        log.info("userDTO : " + userDTO);

        UserDTO savedUser = userService.save(userDTO);

        log.info("savedUser : " + savedUser);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(savedUser);
    }






}
