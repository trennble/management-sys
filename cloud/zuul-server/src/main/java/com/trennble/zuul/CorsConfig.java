// package com.trennble.zuul;
//
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import org.springframework.web.filter.CorsFilter;
//
// import java.util.ArrayList;
// import java.util.List;
//
// @Configuration
// public class CorsConfig {
//
//     @Bean
//     public CorsFilter corsFilter() {
//
//         final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         final CorsConfiguration config = new CorsConfiguration();
//         config.setAllowCredentials(true); // 允许cookies跨域
//         config.addAllowedOrigin("*");// #允许向该服务器提交请求的URI，*表示全部允许，在SpringMVC中，如果设成*，会自动转成当前请求头中的Origin
//         config.addAllowedHeader("*");// #允许访问的头信息,*表示全部
//         config.addAllowedMethod("OPTIONS");
//         config.addAllowedMethod("HEAD");
//         config.addAllowedMethod("GET");
//         config.addAllowedMethod("PUT");
//         config.addAllowedMethod("POST");
//         config.addAllowedMethod("DELETE");
//         config.addAllowedMethod("PATCH");
//         source.registerCorsConfiguration("/**", config);
//         return new CorsFilter(source);
//     }
// }