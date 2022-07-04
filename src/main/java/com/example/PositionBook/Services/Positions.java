package com.example.PositionBook.Services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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

    public void processNewEvents(Events newEvents){
        HashMap<String,Position> curHashMap = new HashMap<>();
        for (Event curEvent : newEvents.getEvents()){
            String curAccount = curEvent.getAccount();
            String curSecurity = curEvent.getSecurity();
            Position curPosition = curHashMap.getOrDefault(curAccount+curSecurity, new Position(curAccount, curSecurity));
            curPosition.addEvent(curEvent);
            int curQuantity = curPosition.getQuantity();
            curQuantity += curEvent.getQuantity();
            curPosition.setQuantity(curQuantity);
            curHashMap.put(curAccount+curSecurity,curPosition);
        }
        for (var entry : curHashMap.entrySet()) {
            positions.add(entry.getValue());
        }
    }
}

