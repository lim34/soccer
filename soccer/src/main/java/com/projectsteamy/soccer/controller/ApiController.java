package com.projectsteamy.soccer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private String word = "";

    //yell
    @RequestMapping("/yell")
    public String yellSoccer() {
        word = "SOCCER!!!";
        return word;
    }

    //soft voices
    @RequestMapping("/softvoices")
    public String dontyell() {
        word = "soccer...";
        return word;
    }
}
