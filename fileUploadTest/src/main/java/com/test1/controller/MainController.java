package com.test1.controller;

import com.test1.dto.FileDTO;
import com.test1.entity.FileEntity;
import com.test1.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
public class MainController {

    private final FileService fileService;

    @GetMapping(value = {"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<FileEntity> files = fileService.selectAllFile();
        log.info(files);

        model.addAttribute("files", files);

        return "/list";
    }

    @GetMapping("/register")
    public String register(){
        return "/register";
    }

    @PostMapping("/register")
    public String register(FileDTO fileDTO){
        log.info(fileDTO);

        fileService.insertFile(fileDTO);

        return "redirect:/list";
    }
}
