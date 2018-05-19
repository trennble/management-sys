package com.trennble.zuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


    private Logger logger = LoggerFactory.getLogger(ResourceServerConfig.class);

    // @Autowired
    // private CustomAccessTokenConverter customAccessTokenConverter;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/api/auth/**").permitAll().and()
                .antMatcher("/**").authorizeRequests().anyRequest().authenticated();
    }


    // @Override
    // public void configure(final HttpSecurity http) throws Exception {
    //     http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
    //             .and()
    //             .authorizeRequests().anyRequest().permitAll();
    //     // http.exceptionHandling().authenticationEntryPoint((request, response, authException) -> {
    //     //     logger.info("Pre-authenticated entry point called. Rejecting access");
    //     //     response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    //     // });
    // }

    // jwt
    // @Override
    // public void configure(final ResourceServerSecurityConfigurer config) {
    //     config.tokenServices(tokenServices());
    // }
    //
    // @Bean
    // public TokenStore tokenStore() {
    //     return new JwtTokenStore(accessTokenConverter());
    // }
    //
    // @Bean
    // public JwtAccessTokenConverter accessTokenConverter() {
    //     final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    //     converter.setAccessTokenConverter(customAccessTokenConverter);
    //
    //     final Resource resource = new ClassPathResource("public.txt");
    //     String publicKey = null;
    //     try {
    //         publicKey = inputStream2String(resource.getInputStream());
    //     } catch (final IOException e) {
    //         throw new RuntimeException(e);
    //     }
    //     converter.setVerifierKey(publicKey);
    //     return converter;
    // }
    //
    // @Bean
    // @Primary
    // public DefaultTokenServices tokenServices() {
    //     final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
    //     defaultTokenServices.setTokenStore(tokenStore());
    //     return defaultTokenServices;
    // }
    //
    //
    // String inputStream2String(InputStream is) throws IOException {
    //     BufferedReader in = new BufferedReader(new InputStreamReader(is));
    //     StringBuffer buffer = new StringBuffer();
    //     String line = "";
    //     while ((line = in.readLine()) != null) {
    //         buffer.append(line);
    //     }
    //     return buffer.toString();
    // }

}
