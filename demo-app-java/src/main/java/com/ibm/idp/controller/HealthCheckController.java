package com.ibm.idp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;


@RestController
@Hidden
@RequestMapping("/health")
public class HealthCheckController {
    
    @GetMapping("")
    public String index() {
        return "OK";
    }

}
