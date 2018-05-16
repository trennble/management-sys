package com.trennble.auth;

import com.google.common.collect.Sets;
import com.trennble.auth.config.CustomTokenEnhancer;
import com.trennble.auth.config.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.inject.Inject;
import java.security.KeyPair;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 认证服务器配置
 */
// @Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * 认证服务器的安全配置
     * defines the security constraints on the token endpoint.
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()").allowFormAuthenticationForClients();
    }

    // jwt 相关配置
    //
    // @Override
    // public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    //     endpoints.tokenStore(jwtTokenStore())
    //             .accessTokenConverter(jwtAccessTokenConverter())
    //             .authenticationManager(authenticationManager);
    // }
    //
    // @Bean
    // public ClientDetailsService clientDetailsService() {
    //     InMemoryClientDetailsService clientDetailsService = new InMemoryClientDetailsService();
    //     Map<String, ClientDetails> clientDetailsMap = new HashMap<>();
    //     BaseClientDetails supervise = supervise();
    //     supervise.setScope(Sets.newHashSet("openid"));
    //     supervise.setAutoApproveScopes(Sets.newHashSet("openid"));
    //     supervise.setAuthorizedGrantTypes(Sets.newHashSet("authorization_code", "refresh_token", "password", "client_credentials"));
    //     clientDetailsMap.put(supervise.getClientId(), supervise);
    //     clientDetailsService.setClientDetailsStore(clientDetailsMap);
    //     return clientDetailsService;
    // }
    //
    //
    //
    // @Bean
    // public JwtAccessTokenConverter jwtAccessTokenConverter() {
    //     JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    //     KeyPair keyPair = new KeyStoreKeyFactory(
    //             new ClassPathResource("keystore.jks"), "keypass".toCharArray())
    //             .getKeyPair("keypair");
    //     converter.setKeyPair(keyPair);
    //     return converter;
    // }
    //
    // @Bean
    // public TokenStore jwtTokenStore() {
    //     return new JwtTokenStore(jwtAccessTokenConverter());
    // }
    //
    // @Bean
    // @Primary
    // public DefaultTokenServices tokenServices() {
    //     DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
    //     defaultTokenServices.setTokenStore(jwtTokenStore());
    //     defaultTokenServices.setSupportRefreshToken(true);
    //     return defaultTokenServices;
    // }
    //
    // /**
    //  * defines the authorization and token endpoints and the token services.
    //  *
    //  * @param endpoints
    //  * @throws Exception
    //  */
    // @Override
    // public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    //     final TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
    //     tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), jwtAccessTokenConverter()));
    //     endpoints.tokenStore(jwtTokenStore())
    //             .tokenEnhancer(tokenEnhancerChain)
    //             .authenticationManager(authenticationManager);
    // }
    //
    // @Bean
    // public TokenEnhancer tokenEnhancer() {
    //     return new CustomTokenEnhancer();
    // }

}
