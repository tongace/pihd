package com.dxc.toyota.application.pihd.controllers;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping({"/home","/"})
    public String home(){
        return "/home.html";
    }
    @RequestMapping("/home/js/home.js")
    public String homeJs(){
        return "/home.js";
    }
}
