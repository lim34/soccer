package com.projectsteamy.soccer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private String word = "";
    private List<String> players = new ArrayList<>();

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

    @RequestMapping("/players")
    public List<String> getPlayers() {
        players.add("Messi");
        players.add("Ronaldo");
        players.add("Neymar");
        return players;
    }
}
