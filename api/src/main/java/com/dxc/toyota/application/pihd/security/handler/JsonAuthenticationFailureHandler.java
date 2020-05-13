package com.dxc.toyota.application.pihd.security.handler;

import com.dxc.toyota.application.pihd.models.ApiResult;
import com.dxc.toyota.application.pihd.utils.ResponseUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class JsonAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        log.info("@@@@@ in onAuthenticationFailure");
        ObjectMapper objectMapper = new ObjectMapper();
        ApiResult result;
        if (e instanceof UsernameNotFoundException) {
            result = new ApiResult<String>(HttpStatus.UNAUTHORIZED.value(),e.getMessage(),"Wrong User Name");
        } else if(e instanceof BadCredentialsException){
            result = new ApiResult<String>(HttpStatus.UNAUTHORIZED.value(),e.getMessage(),"Wrong Password");
        } else {
            result = new ApiResult<String>(HttpStatus.UNAUTHORIZED.value(),e.getMessage(),"Login failed!");
        }
        log.info("@@@@@ end onAuthenticationFailure with return Data >>>"+objectMapper.writeValueAsString(result));
        ResponseUtils.out(response, result);

    }
}
