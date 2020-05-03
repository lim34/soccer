package com.projectsteamy.soccer.model;

import lombok.Data;

@Data
public class Rating {

    private int overall;
    private int speed;
    private int strength;
    private int agility;
    private int accuracy;

    public int getOverall() {return overall;}
    public int getSpeed() {return speed;}
    public int getStrength() {return strength;}
    public int getAgility() {return agility;}
    public int getAccuracy() {return accuracy;}
}
