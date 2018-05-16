package com.trennble.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AccessLogFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(AccessLogFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        HttpServletResponse response = RequestContext.getCurrentContext().getResponse();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails;
        // if (authentication.isAuthenticated()){
        //     userDetails = (UserDetails) authentication.getPrincipal();
        //     logger.info("user&pass:"+userDetails.getUsername()+"/"+userDetails.getPassword());
        // }

        logger.info("REQUEST :: <" + request.getScheme() + ":"+request.getMethod()+"> LOCAL-" + request.getLocalAddr() + ":" + request.getLocalPort() + " REMOTE-" + request.getRemoteAddr() + ":" + request.getRemotePort());
        logger.info("REQUEST :: < " + request.getProtocol() + " " + request.getRequestURI());
        logger.info("RESPONSE:: > HTTP:" + response.getStatus());


        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");

        return null;
    }
}
