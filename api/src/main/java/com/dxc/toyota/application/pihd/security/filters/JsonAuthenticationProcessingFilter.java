package com.dxc.toyota.application.pihd.security.filters;

import com.dxc.toyota.application.pihd.security.handler.JsonAuthenticationFailureHandler;
import com.dxc.toyota.application.pihd.security.handler.JsonAuthenticationSuccessHandler;
import com.dxc.toyota.application.pihd.security.manager.CustomAuthenticationManager;
import com.dxc.toyota.application.pihd.security.models.LoginCredentials;
import com.dxc.toyota.application.pihd.utils.DXCStringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Slf4j
public class JsonAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    public JsonAuthenticationProcessingFilter(CustomAuthenticationManager manager,
                                              JsonAuthenticationSuccessHandler successHandler,
                                              JsonAuthenticationFailureHandler failureHandler) {
        super(new AntPathRequestMatcher("/login", "POST"));
        this.setAuthenticationManager(manager);
        this.setAuthenticationSuccessHandler(successHandler);
        this.setAuthenticationFailureHandler(failureHandler);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        UsernamePasswordAuthenticationToken authentication;
        try {
            LoginCredentials credentials = new ObjectMapper().readValue(request.getInputStream(), LoginCredentials.class);
            log.debug("@@@ user name @@@@"+credentials.getUsername());
            log.debug("@@@ password @@@@"+credentials.getPassword());
            authentication = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword(), null);
            authentication.setDetails(authenticationDetailsSource.buildDetails(request));
        } catch (Exception e) {
            throw new AuthenticationServiceException(e.getMessage());
        }
        return getAuthenticationManager().authenticate(authentication);
    }
}
