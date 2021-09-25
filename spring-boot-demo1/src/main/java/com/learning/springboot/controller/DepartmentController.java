package com.learning.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    //@RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "Hello Learner";
    }
}
