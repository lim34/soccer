package com.projectsteamy.soccer.model;

import lombok.Data;

@Data
public class Position {
    private int id;
    private String position;
    private String description;

    public int getId() { return id; }
    public String getPosition() { return position; }
    public String getDescription() { return description; }

}
