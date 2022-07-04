package com.example.PositionBook.Services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Positions {
    private List<Position> positions;

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

