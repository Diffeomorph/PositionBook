package com.example.positionbook.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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
        TreeMap<String,Position> curTreeMap = new TreeMap<>();
        for (Event curEvent : newEvents.getEvents()){
            String curAccount = curEvent.getAccount();
            String curSecurity = curEvent.getSecurity();
            Position curPosition = curTreeMap.getOrDefault(curAccount+curSecurity, new Position(curAccount, curSecurity));

            if (curEvent.getAction().equals("CANCEL")){
                for (Event event: curPosition.getEvents()){
                    if (event.getId() == curEvent.getId()){
                        int curQuantity = curPosition.getQuantity();
                        curQuantity -= event.getQuantity();
                        curPosition.setQuantity(curQuantity);
                    }
                }
            }

            curPosition.addEvent(curEvent);

            int curQuantity = curPosition.getQuantity();
            if (curEvent.getAction().equals("BUY")){
                curQuantity += curEvent.getQuantity();
            } else if (curEvent.getAction().equals("SELL")){
                curQuantity -= curEvent.getQuantity();
            }

            curPosition.setQuantity(curQuantity);
            curTreeMap.put(curAccount+curSecurity,curPosition);
        }

        for (var entry : curTreeMap.entrySet()) {
            positions.add(entry.getValue());
        }
    }
}

