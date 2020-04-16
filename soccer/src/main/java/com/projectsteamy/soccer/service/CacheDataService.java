package com.projectsteamy.soccer.service;

import com.projectsteamy.soccer.model.Continent;
import com.projectsteamy.soccer.model.Country;
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

    @PostConstruct
    public void init() throws Exception {
        continentHashMap = jsonService.getContinents();
        countryHashMap = jsonService.getCountries();
        LOG.info("Data Loading / Caching Successful.");
    }

    public static HashMap<Integer, Continent> getContinentHashMap() {
        return continentHashMap;
    }

    public static HashMap<Integer, Country> getCountryHashMap() {
        return countryHashMap;
    }
}
