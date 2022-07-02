package com.example.PositionBook.Services;

import java.util.List;

public class Events {
    private List<Event> events;

    public Events(){

    }
    public List<Event> getEvents(){
        return events;
    }

    public void addEvent(Event newEvent){
        events.add(newEvent);
    }
}
