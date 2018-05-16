package com.trennble.sys;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
// @EnableRedisHttpSession
// @EnableOAuth2Sso
// @EntityScan({"com.trennble.invoice.entity","com.trennble.auth.entity"})
public class SysApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SysApplication.class).web(true).run(args);
    }

}
