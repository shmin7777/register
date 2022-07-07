package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RegisterService;

import kr.co.openlabs.mtf.core.xid.MtfContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@Slf4j
public class RegisterController {
    
    private final RegisterService registerService;
    
    @GetMapping("/register")
    public String regist(String code, String gid) {
        if (gid != "" && gid != null)
            MtfContext.setXid(gid);
        registerService.regist(code);
        return "Success";
    }
    
}
