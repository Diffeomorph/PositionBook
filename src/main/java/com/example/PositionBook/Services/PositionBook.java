package com.example.PositionBook.Services;

import java.util.TreeMap;

public class PositionBook {
    final TreeMap<Pair<String,String>,Events> positionBook; // <account, security> -> list of events

    public PositionBook(){
        this.positionBook = new TreeMap();
    }

    public void addEventsListToPositionBook(Events newEvents){
        for (Event curEvent: newEvents.getEvents()){
            String curAccount = curEvent.getAccount();
            String curSecurity = curEvent.getSecurity();
            Pair curPair = new Pair(curAccount,curSecurity);
            Events curSelection = positionBook.getOrDefault(curPair,new Events());
            curSelection.addEvent(curEvent);
        }
    }
}
