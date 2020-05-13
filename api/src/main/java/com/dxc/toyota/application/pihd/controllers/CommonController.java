package com.dxc.toyota.application.pihd.controllers;

import com.dxc.toyota.application.pihd.services.ICommonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("common")
@Slf4j
@RequiredArgsConstructor
public class CommonController {
    private final ICommonService commonService;

    @GetMapping(value = "/rest/servertime", produces = MediaType.APPLICATION_JSON_VALUE)
    public Date getDbServerDatetime(){
        return commonService.getDatabaseDateTime();
    }
    @PreAuthorize("hasAnyRole('ALL','SY01')")
    @GetMapping(value = "/rest/servertime2", produces = MediaType.APPLICATION_JSON_VALUE)
    public Date getDbServerDatetime2(){
        return commonService.getDatabaseDateTime();
    }
}
