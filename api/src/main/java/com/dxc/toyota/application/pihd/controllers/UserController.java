package com.dxc.toyota.application.pihd.controllers;

import com.dxc.toyota.application.pihd.models.SystemParameterModel;
import com.dxc.toyota.application.pihd.services.ISystemParameterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final ISystemParameterService parameterService;

    @GetMapping("/usermaintenance/rest/params")
    public List<SystemParameterModel> getSystemParameter()
    {
        List<SystemParameterModel> retList =parameterService.findByCategory("STATUS_PLAN","Y");
        return retList;
    }
}
