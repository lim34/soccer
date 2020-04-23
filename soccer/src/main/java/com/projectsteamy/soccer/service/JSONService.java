package com.projectsteamy.soccer.service;
import com.projectsteamy.soccer.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class JSONService {

    public Continent getContinent(String sId) throws Exception {
        int id = validateId(sId);
        HashMap<Integer, Continent> continentHashMap = CacheDataService.getContinentHashMap();
        return continentHashMap.get(id);
    }

    public Country getCountry(String sId) throws Exception {
        int id = validateId(sId);
        HashMap<Integer, Country> countryHashMap = CacheDataService.getCountryHashMap();
        return countryHashMap.get(id);

    }

    public League getLeague(String sId) throws Exception {
        int id = validateId(sId);
        HashMap<Integer, League> leagueHashMap = CacheDataService.getLeagueHashMap();
        return leagueHashMap.get(id);
    }

    public Position getPosition(String sId) throws Exception {
        int id = validateId(sId);
        HashMap<Integer, Position> positionHashMap = CacheDataService.getPositionHashMap();
        return positionHashMap.get(id);
    }

    public Team getTeam(String sId) throws Exception {
        int id = validateId(sId);
        HashMap<Integer, Team> teamHashMap = CacheDataService.getTeamHashMap();
        return teamHashMap.get(id);
    }

    public List<Country> getCountries(String sContinentId) throws Exception {
        int continentId = validateId(sContinentId);
        HashMap<Integer, Country> countryHashMap = CacheDataService.getCountryHashMap();
        List<Country> countries = new ArrayList<>();
        countryHashMap.forEach((k, v) -> {
            if(v.getContinent() == continentId) {
                countries.add(v);
            }
        });
        return countries;
    }

    public List<League> getLeagues(String sCountryId) throws Exception {
        int countryId = validateId(sCountryId);
        HashMap<Integer, League> leagueHashMap = CacheDataService.getLeagueHashMap();
        List<League> leagues = new ArrayList<>();
        leagueHashMap.forEach((k, v) -> {
            if(v.getCountry() == countryId) {
                leagues.add(v);
            }
        });
        return leagues;
    }

    public List<Team> getTeams(String sLeagueId) throws Exception {
        int leagueId = validateId(sLeagueId);
        HashMap<Integer, Team> teamHashMap = CacheDataService.getTeamHashMap();
        List<Team> teams = new ArrayList<>();
        teamHashMap.forEach((k, v) -> {
            if(v.getLeague() == leagueId) {
                teams.add(v);
            }
        });
        return teams;
    }

    //validates String of id then gives an integer value of the id.
    private int validateId(String sId) throws Exception {
        if(sId.isEmpty() || sId.isBlank()) {
            throw new Exception("You passed no data.");
        }

        int id;
        try {
            id = Integer.valueOf(sId);
        } catch (Exception ex) {
            throw new Exception("You passed invalid data.");
        }
        return id;
    }

}
