package com.example.demo01.controler;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControler {

    @GetMapping("/public/current/user")
    public String getCurrentUser(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
