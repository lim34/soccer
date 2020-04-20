package com.projectsteamy.soccer.model.wrapper;

import com.projectsteamy.soccer.model.Country;
import lombok.Data;

import java.util.List;

@Data
public class CountryWrapper {
    private List<Country> countries;

    public List<Country> getCountryList() { return countries; }



}
