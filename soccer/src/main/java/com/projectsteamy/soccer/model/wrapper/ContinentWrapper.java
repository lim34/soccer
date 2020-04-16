package com.projectsteamy.soccer.model.wrapper;

import com.projectsteamy.soccer.model.Continent;
import lombok.Data;

import java.util.List;

@Data
public class ContinentWrapper {
    private List<Continent> continents;

    public List<Continent> getContinentList() { return continents; }
}
