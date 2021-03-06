package com.projectsteamy.soccer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectsteamy.soccer.constant.ApiConstants;
import com.projectsteamy.soccer.model.*;
import com.projectsteamy.soccer.model.wrapper.*;
import org.jboss.logging.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@Service
public class CacheDataService {

    private static final Logger LOG
            = Logger.getLogger(CacheDataService.class);

    private static HashMap<Integer, Continent> continentHashMap;
    private static HashMap<Integer, Country> countryHashMap;
    private static HashMap<Integer, League> leagueHashMap;
    private static HashMap<Integer, Position> positionHashMap;
    private static HashMap<Integer, Team> teamHashMap;

    @PostConstruct
    public void init() throws Exception {
        continentHashMap = getContinents();
        countryHashMap = getCountries();
        leagueHashMap = getLeagues();
        positionHashMap = getPositions();
        teamHashMap = getTeams();
        LOG.info("Data Loading / Caching Successful.");
    }

    private ObjectMapper objectMapper = new ObjectMapper();

    private String getJSONFile(String fileName) throws Exception {
        ClassPathResource file = new ClassPathResource(fileName);
        byte[] bdata = FileCopyUtils.copyToByteArray(file.getInputStream());
        return new String(bdata, StandardCharsets.UTF_8);
    }

    public HashMap<Integer, Continent> getContinents() throws Exception {
        ContinentWrapper continentWrapper = objectMapper.readValue(getJSONFile(ApiConstants.CONTINENTS_FILE), ContinentWrapper.class);
        HashMap<Integer, Continent> continentMap = new HashMap<>();
        continentWrapper.getContinentList().forEach(item -> {
            continentMap.put(item.getId(), item);
        });
        return continentMap;
    }

    public HashMap<Integer, Country> getCountries() throws Exception {
        CountryWrapper countryWrapper = objectMapper.readValue(getJSONFile(ApiConstants.COUNTRIES_FILE), CountryWrapper.class);
        HashMap<Integer, Country> countryMap = new HashMap<>();
        countryWrapper.getCountryList().forEach(item -> {
            countryMap.put(item.getId(), item);
        });
        return countryMap;
    }

    public HashMap<Integer, League> getLeagues() throws Exception {
        LeagueWrapper leagueWrapper = objectMapper.readValue(getJSONFile(ApiConstants.LEAGUES_FILE), LeagueWrapper.class);
        HashMap<Integer, League> leagueMap = new HashMap<>();
        leagueWrapper.getLeagueList().forEach(item -> {
            leagueMap.put(item.getId(), item);
        });

        return leagueMap;
    }

    public HashMap<Integer, Position> getPositions() throws Exception {
        PositionWrapper positionWrapper = objectMapper.readValue(getJSONFile(ApiConstants.POSITIONS_FILE), PositionWrapper.class);
        HashMap<Integer, Position> positionMap = new HashMap<>();
        positionWrapper.getPositionList().forEach(item -> {
            positionMap.put(item.getId(), item);
        });

        return positionMap;
    }

    public HashMap<Integer, Team> getTeams() throws Exception {
        TeamWrapper teamWrapper = objectMapper.readValue(getJSONFile(ApiConstants.TEAMS_FILE), TeamWrapper.class);
        HashMap<Integer, Team> teamMap = new HashMap<>();
        teamWrapper.getTeamList().forEach(item -> {
            teamMap.put(item.getId(), item);
        });

        return teamMap;
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
