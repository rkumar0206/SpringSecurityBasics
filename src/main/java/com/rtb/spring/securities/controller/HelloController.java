package com.rtb.spring.securities.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {

        return "Learning Spring Security";
    }

    @GetMapping("/bye")
    public String bye() {

        return "Get Lost!!";
    }

}
