package com.dxc.toyota.application.pihd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessDeniedController {
    @GetMapping("/accessdenied")
    public String gotoPage() {
        return "/accessdenied.html";
    }
}
