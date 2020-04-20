package com.projectsteamy.soccer.model.wrapper;

import com.projectsteamy.soccer.model.Team;
import lombok.Data;

import java.util.List;

@Data
public class TeamWrapper {
    private List<Team> teams;

    public List<Team> getTeamList() { return teams; }
}
