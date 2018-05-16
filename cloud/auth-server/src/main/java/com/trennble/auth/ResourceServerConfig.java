package com.trennble.auth;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

// @Configurable
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
}
