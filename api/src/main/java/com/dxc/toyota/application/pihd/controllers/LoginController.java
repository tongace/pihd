package com.dxc.toyota.application.pihd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/applogin")
    String login() {
        return "/login.html";
    }
    @GetMapping("/applogin/js/login.js")
    String loginJs() {
        return "/login.js";
    }
}
