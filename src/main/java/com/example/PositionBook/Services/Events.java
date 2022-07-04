package com.example.PositionBook.Services;

import java.util.ArrayList;
import java.util.List;

public class Events {
    private List<Event> Events = new ArrayList<>();

    public List<Event> getEvents() {
        return Events;
    }

    public void setEvents(List<Event> Events){
        this.Events = Events;
    }
}
