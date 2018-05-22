package com.trennble.invoice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trennble.invoice.rpc.UserRpc;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class TestController {

    @Inject
    private UserRpc userRpc;

    @GetMapping("hello")
    public String hello(HttpServletRequest request) throws JsonProcessingException {
        Integer id = (Integer) ((HashMap) userRpc.user().get("principal")).get("id");
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        return (new ObjectMapper()).writeValueAsString(userDetails);
    }
}
