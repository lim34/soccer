package com.projectsteamy.soccer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectsteamy.soccer.constant.ApiConstants;
import com.projectsteamy.soccer.model.Continent;
import com.projectsteamy.soccer.model.Country;
import com.projectsteamy.soccer.model.wrapper.ContinentWrapper;
import com.projectsteamy.soccer.model.wrapper.CountryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.HashMap;

@Service
public class JSONService {

    private ObjectMapper objectMapper = new ObjectMapper();

    private File getJSONFile(String fileName) throws Exception {
        StringBuilder sb = new StringBuilder("classpath:").append(fileName);
        File file = ResourceUtils.getFile(sb.toString());
        return file;
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

}
