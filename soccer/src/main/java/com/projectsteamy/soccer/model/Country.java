package com.projectsteamy.soccer.model;

import lombok.Data;

@Data
public class Country {
    private int id;
    private int continent;
    private String name;

    public int getId() { return id; }
    public String getName() { return name; }
    public int getContinent() { return continent; }

}
