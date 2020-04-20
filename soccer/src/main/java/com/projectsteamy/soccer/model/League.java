package com.projectsteamy.soccer.model;

import lombok.Data;

@Data
public class League {

    private int id;
    private int country;
    private String name;

    public int getId() { return id; }
    public int getCountry() { return country; }
    public String getName() { return name; }

}
