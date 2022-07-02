package com.example.PositionBook.Services;

import org.springframework.stereotype.Service;

import java.util.TreeMap;

@Service
public class Positions {
    private TreeMap<Pair<String,String>,Events> positionBook; // <account, security> -> list of events

    public Positions(){
        this.positionBook = new TreeMap();
    }

    public void addEventsListToPositionBook(Events newEvents){
        for (Event curEvent: newEvents.getEvents()){
            String curAccount = curEvent.getAccount();
            String curSecurity = curEvent.getSecurity();
            Pair curPair = new Pair(curAccount,curSecurity);
            Events curSelection = positionBook.getOrDefault(curPair,new Events());
            curSelection.addEvent(curEvent);
            System.out.println("second");
        }
    }
}
