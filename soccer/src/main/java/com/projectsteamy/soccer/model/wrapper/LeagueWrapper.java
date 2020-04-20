package com.projectsteamy.soccer.model.wrapper;

import com.projectsteamy.soccer.model.League;
import lombok.Data;

import java.util.List;

@Data
public class LeagueWrapper {
    private List<League> leagues;

    public List<League> getLeagueList() { return leagues; }

}
