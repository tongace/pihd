package com.dxc.toyota.application.pihd.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("hasAnyRole('ALL','SY01')")
public class UserMaintenanceController {
    @GetMapping("/usermaintenance")
    public String getPage(){
        return "/usermtn.html";
    }
    @GetMapping("/usermaintenance/js/usermtn.js")
    public String homeJs(){
        return "/usermtn.js";
    }
}
