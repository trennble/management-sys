package com.trennble.sys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("hello")
    public String hello(){
        // UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
        //         .getAuthentication()
        //         .getPrincipal();
        // return "hello "+userDetails.getUsername()+" in sys";
        return "hello sys";
    }
}
