package com.example.PositionBook.Services;

import java.util.TreeMap;

public class PositionBook {
    final TreeMap<Pair<String,String>,Events> positions; // <account, security> -> list of events

    public PositionBook(){
        this.positions = new TreeMap();
    }

    public void addEventsListToPositionBook(Events newEvents){
        for (Event curEvent: newEvents.getEvents()){
            String curAccount = curEvent.getAccount();
            String curSecurity = curEvent.getSecurity();
            Pair curPair = new Pair(curAccount,curSecurity);
            Events curSelection = positions.getOrDefault(curPair,new Events());
            curSelection.addEvent(curEvent);
        }
    }
}
