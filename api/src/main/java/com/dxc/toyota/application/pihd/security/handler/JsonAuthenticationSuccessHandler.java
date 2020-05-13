package com.dxc.toyota.application.pihd.security.handler;

import com.dxc.toyota.application.pihd.models.ApiResult;
import com.dxc.toyota.application.pihd.utils.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JsonAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
        UserDetails userDetails = (UserDetails)auth.getDetails();
        ResponseUtils.out(response, new ApiResult<UserDetails>(HttpStatus.OK.value(),"Login successfully!", userDetails));
    }
}
