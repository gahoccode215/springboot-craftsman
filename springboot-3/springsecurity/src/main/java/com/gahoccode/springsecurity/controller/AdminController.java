package com.gahoccode.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @GetMapping("/vip")
    public String zoneVip(){
        return "zoneVip";
    }
    @GetMapping("normal")
    public String zoneNormal(){
        return "zoneNormal";
    }
}
