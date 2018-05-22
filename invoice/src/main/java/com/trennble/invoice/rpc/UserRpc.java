package com.trennble.invoice.rpc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.HashMap;

@FeignClient(name = "auth")
public interface UserRpc {


    @GetMapping("/user")
    HashMap user();
}
