package com.dxc.toyota.application.pihd.security.handler;

import com.dxc.toyota.application.pihd.models.ApiResult;
import com.dxc.toyota.application.pihd.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exc) throws IOException, ServletException {
        log.error(exc.getMessage(),exc);
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            log.info("auth.isAuthenticated() >>> "+auth.isAuthenticated());
            log.warn("User: " + auth.getName()+ " attempted to access the protected URL: "+ request.getRequestURI());
        }
        log.info("before send redirect to access denied");
        if(StringUtils.containsIgnoreCase(request.getRequestURI(),"/rest/"))
        {
            ApiResult<String> result = new ApiResult<String>();
            result.setCode(HttpStatus.FORBIDDEN.value());
            result.setMessage("access denied");
            result.setData("access denied");
            ResponseUtils.out(response,result);
        }else{
            response.sendRedirect(request.getContextPath() + "/accessdenied");
        }
    }
}
