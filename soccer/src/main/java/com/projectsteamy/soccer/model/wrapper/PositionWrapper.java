package com.projectsteamy.soccer.model.wrapper;

import com.projectsteamy.soccer.model.Position;
import lombok.Data;

import java.util.List;

@Data
public class PositionWrapper {
    private List<Position> positions;

    public List<Position> getPositionList() { return positions; }
}
