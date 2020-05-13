package com.dxc.toyota.application.pihd.security.services;

import com.dxc.toyota.application.pihd.models.UserModel;
import com.dxc.toyota.application.pihd.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class CustomUserDetailServices implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userMapper.findByUserId(username);
        if (userModel==null) {
            throw new UsernameNotFoundException("Username not found");
        }

        UserDetails userDetails = new User(userModel.getUserId(),userModel.getPassword(), getGrantedAuthorities(userModel.getAuthorities()));
       return userDetails;
    }
    private List<GrantedAuthority> getGrantedAuthorities(String authorities) {
        String []authorityArr = StringUtils.split(authorities,",");
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (String authority : authorityArr) {
            authorityList.add(new SimpleGrantedAuthority("ROLE_"+StringUtils.trim(authority)));
        }
        return authorityList;
    }
}
