package com.projectsteamy.soccer.model;

import lombok.Data;

@Data
public class Continent {
    private int id;
    private String name;

    public int getId() { return id; }
    public String getName() { return name; }
}
