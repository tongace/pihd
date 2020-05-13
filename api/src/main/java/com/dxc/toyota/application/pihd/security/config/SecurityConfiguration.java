package com.dxc.toyota.application.pihd.security.config;

import com.dxc.toyota.application.pihd.security.filters.JsonAuthenticationProcessingFilter;
import com.dxc.toyota.application.pihd.security.handler.CustomAccessDeniedHandler;
import com.dxc.toyota.application.pihd.security.handler.CustomAuthenticationEntryPoint;
import com.dxc.toyota.application.pihd.security.handler.JsonAuthenticationFailureHandler;
import com.dxc.toyota.application.pihd.security.handler.JsonAuthenticationSuccessHandler;
import com.dxc.toyota.application.pihd.security.manager.CustomAuthenticationManager;
import com.dxc.toyota.application.pihd.security.services.CustomUserDetailServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    String[] resources = new String[]{
            "/css/**","/scripts/**","/images/**","/applogin/**","/common/rest/servertime"
    };
    @Autowired
    JsonAuthenticationSuccessHandler successHandler;
    @Autowired
    JsonAuthenticationFailureHandler failureHandler;
    @Autowired
    CustomAuthenticationManager authenticationManager;
    @Autowired
    CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    @Autowired
    CustomAccessDeniedHandler customAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(resources).permitAll()
                .anyRequest().authenticated()
                .and()
                    .exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint)
                .accessDeniedHandler(customAccessDeniedHandler)
                .and()
                .logout()
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/applogin")
                .and()
                .addFilterAt(
                        new JsonAuthenticationProcessingFilter(authenticationManager,successHandler,failureHandler),
                        UsernamePasswordAuthenticationFilter.class
                );
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
