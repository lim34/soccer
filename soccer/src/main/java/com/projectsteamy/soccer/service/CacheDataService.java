package com.projectsteamy.soccer.service;

import com.projectsteamy.soccer.model.*;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
public class CacheDataService {

    private static final Logger LOG
            = Logger.getLogger(CacheDataService.class);

    @Autowired
    private JSONService jsonService;
    private static HashMap<Integer, Continent> continentHashMap;
    private static HashMap<Integer, Country> countryHashMap;
    private static HashMap<Integer, League> leagueHashMap;
    private static HashMap<Integer, Position> positionHashMap;
    private static HashMap<Integer, Team> teamHashMap;

    @PostConstruct
    public void init() throws Exception {
        continentHashMap = jsonService.getContinents();
        countryHashMap = jsonService.getCountries();
        leagueHashMap = jsonService.getLeagues();
        positionHashMap = jsonService.getPositions();
        teamHashMap = jsonService.getTeams();
        LOG.info("Data Loading / Caching Successful.");
    }

    public static HashMap<Integer, Continent> getContinentHashMap() {
        return continentHashMap;
    }

    public static HashMap<Integer, Country> getCountryHashMap() {
        return countryHashMap;
    }

    public static HashMap<Integer, League> getLeagueHashMap() { return leagueHashMap; }

    public static HashMap<Integer, Position> getPositionHashMap() { return positionHashMap; }

    public static HashMap<Integer, Team> getTeamHashMap() { return teamHashMap; }

    public static int calculateNum(int num) {
        if(num <= 1) {
            return num;
        }
        return num + calculateNum(num - 1);
    }
}
