package com.example.PositionBook.Services;

import java.util.List;

public class Events {
    private List<Event> Events;

    public List<Event> getEvents() {
        return Events;
    }

    public void setEvents(List<Event> newEvents){
        this.Events = newEvents;
    }
}
