package com.learning.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private MessageSource messageSource;

    // Note : With i18n (internationalization) support
    @GetMapping("/hello")
    public String hello() {
        // @RequestHeader(name = "Accept-Language", required = false) Locale locale
        String message = messageSource
                .getMessage("greeting.message", null, "Default Greeting", LocaleContextHolder.getLocale());
        return message;
    }
}
