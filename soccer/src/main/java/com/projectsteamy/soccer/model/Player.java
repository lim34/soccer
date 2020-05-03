package com.projectsteamy.soccer.model;

import lombok.Data;

@Data
public class Player {

    private int id;
    private String firstName;
    private String lastName;
    private Rating rating;
    private int nationalTeam;
    private int clubTeam;
    private int position;

    public int getId() {return id;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public Rating getRating() {return rating;}
    public int getNationalTeam() {return nationalTeam;}
    public int getClubTeam() {return clubTeam;}
    public int getPosition() {return position;}
}
