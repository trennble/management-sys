package com.trennble.auth.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import javax.inject.Inject;

/**
 * 自定义用户登陆逻辑配置
 */
// @Configuration
// @EnableAuthorizationServer
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    private Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .and().authorizeRequests().antMatchers("/user").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
                .and().logout().permitAll();

        // http.exceptionHandling().authenticationEntryPoint((request, response, authException) -> {
        //
        //     logger.info("Pre-authenticated entry point called. Rejecting access");
        //     response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        // });
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        // web.ignoring().antMatchers("/static/css/**","/templates/**");
    }
}
