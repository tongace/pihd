package com.dxc.toyota.application.pihd.security.provider;

import com.dxc.toyota.application.pihd.security.services.CustomUserDetailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.BeanIds;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    CustomUserDetailServices userDetailsService;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Get the user name and password returned after input in the front-end form
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        boolean isMatched = passwordEncoder.matches(password,userDetails.getPassword());
        if (!isMatched) {
            throw new BadCredentialsException("Wrong password!");
        }
        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
