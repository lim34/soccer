package com.projectsteamy.soccer.model.wrapper;

import com.projectsteamy.soccer.model.Player;
import lombok.Data;

import java.util.List;

@Data
public class PlayerWrapper {
    private List<Player> players;

    public List<Player> getPlayerList() {return players;}
}
