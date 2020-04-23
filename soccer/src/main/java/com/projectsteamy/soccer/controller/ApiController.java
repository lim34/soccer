package com.projectsteamy.soccer.controller;

import com.projectsteamy.soccer.model.*;
import com.projectsteamy.soccer.service.CacheDataService;
import com.projectsteamy.soccer.service.JSONService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private JSONService jsonService;

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

    @RequestMapping("/getContinent")
    public Continent getContinent(@RequestParam String sId) throws Exception {
        return jsonService.getContinent(sId);
    }

    @RequestMapping("/getCountry")
    public Country getCountry(@RequestParam String sId) throws Exception {
        return jsonService.getCountry(sId);
    }

    @RequestMapping("/getLeague")
    public League getLeague(@RequestParam String sId) throws Exception {
        return jsonService.getLeague(sId);
    }

    @RequestMapping("/getPosition")
    public Position getPosition(@RequestParam String sId) throws Exception {
        return jsonService.getPosition(sId);
    }

    @RequestMapping("/getTeam")
    public Team getTeam(@RequestParam String sId) throws Exception {
        return jsonService.getTeam(sId);
    }

    @RequestMapping("getCountries")
    public List<Country> getCountries(@RequestParam String sContinentId) throws Exception {
        return jsonService.getCountries(sContinentId);
    }

    @RequestMapping("getLeagues")
    public List<League> getLeagues(@RequestParam String sCountryId) throws Exception {
        return jsonService.getLeagues(sCountryId);
    }

    @RequestMapping("getTeams")
    public List<Team> getTeams(@RequestParam String sLeagueId) throws Exception {
        return jsonService.getTeams(sLeagueId);
    }
}
