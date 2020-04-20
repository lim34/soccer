package com.projectsteamy.soccer.controller;

import com.projectsteamy.soccer.model.*;
import com.projectsteamy.soccer.service.CacheDataService;
import com.projectsteamy.soccer.service.JSONService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
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

    //players call
    @RequestMapping("/players")
    public List<String> getPlayers() {
        players.add("Messi");
        players.add("Ronaldo");
        players.add("Neymar");

        return players;
    }

    @RequestMapping("/continents")
    public HashMap<Integer, Continent> getContinents() throws Exception {
        return CacheDataService.getContinentHashMap();
    }

    @RequestMapping("/countries")
    public HashMap<Integer, Country> getCountries() throws Exception {
        return CacheDataService.getCountryHashMap();
    }

    @RequestMapping("/leagues")
    public HashMap<Integer, League> getLeagues() throws Exception {
        return CacheDataService.getLeagueHashMap();
    }

    @RequestMapping("/positions")
    public HashMap<Integer, Position> getPositions() throws Exception {
        return CacheDataService.getPositionHashMap();
    }

    @RequestMapping("/teams")
    public HashMap<Integer, Team> getTeams() throws Exception {
        return CacheDataService.getTeamHashMap();
    }

    @RequestMapping("/num")
    public int getNum(@RequestParam int num) {
        return CacheDataService.calculateNum(num);
    }
}
