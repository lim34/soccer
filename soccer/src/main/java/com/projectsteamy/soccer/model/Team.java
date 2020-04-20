package com.projectsteamy.soccer.model;

import lombok.Data;

import java.util.List;

@Data
public class Team {
    private int id;
    private String name;
    private int teamType;
    private int country;
    private int league;
    private String coach;
    private List<Integer> players;

    public int getId() { return id; }
    public String getName() { return name; }
    public int getTeamType() { return teamType; }
    public int getCountry() { return country; }
    public int getLeague() { return league; }
    public List<Integer> getPlayers() { return players; }
}
