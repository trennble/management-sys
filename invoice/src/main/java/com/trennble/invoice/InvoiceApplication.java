package com.trennble.invoice;

import org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringCloudApplication
@EnableFeignClients
// @EnableRedisHttpSession
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class,ManagementWebSecurityAutoConfiguration.class})
@EnableJpaRepositories("com.trennble.invoice.repo")
@EntityScan({"com.trennble.invoice.entity","com.trennble.auth.entity"})
public class InvoiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(InvoiceApplication.class).web(true).run(args);
    }

}
