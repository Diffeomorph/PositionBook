package com.example.positionbook.services;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Position {
    @JsonProperty("Account")
    private String account;
    @JsonProperty("Security")
    private String security;
    @JsonProperty("Quantity")
    private Integer quantity;
    @JsonProperty("Events")
    private List<Event> events;

    public Position(String account, String security){
        this.account = account;
        this.security = security;
        this.quantity = 0;
        this.events = new ArrayList<>();
    }

    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getSecurity() {
        return security;
    }
    public void setSecurity(String security) {
        this.security = security;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public List<Event> getEvents() {
        return events;
    }
    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void addEvent(Event event){
        events.add(event);
    }

}
