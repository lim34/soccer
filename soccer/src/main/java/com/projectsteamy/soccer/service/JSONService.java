package com.projectsteamy.soccer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectsteamy.soccer.constant.ApiConstants;
import com.projectsteamy.soccer.model.*;
import com.projectsteamy.soccer.model.wrapper.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@Service
public class JSONService {

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

}
