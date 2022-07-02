package com.example.PositionBook.Services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Service
public class Positions {
    private TreeMap<Pair<String,String>,List<Event>> positionBook; // <account, security> -> list of events

    public Positions(){
        this.positionBook = new TreeMap();
    }

    public void addEventsListToPositionBook(Events newEvents){
        for (Event curEvent: newEvents.getEvents()){
            String curAccount = curEvent.getAccount();
            String curSecurity = curEvent.getSecurity();
            Pair curPair = new Pair(curAccount,curSecurity);
            List<Event> curSelection = positionBook.getOrDefault(curPair,new ArrayList<>());
            curSelection.add(curEvent);
            positionBook.put(curPair, curSelection);
        }
    }
}
