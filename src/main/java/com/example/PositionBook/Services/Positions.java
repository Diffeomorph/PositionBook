package com.example.PositionBook.Services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Positions {
    private List<Position> positions = new ArrayList<>();

    public List<Position> getPositions() {
        return positions;
    }
    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public void addPosition(Position newPosition){
        positions.add(newPosition);
    }
}

