package com.trennble.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestController {

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }


    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
