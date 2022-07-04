package com.example.PositionBook.Services;

import java.util.ArrayList;
import java.util.List;

public class Position {
    private String account;
    private String security;
    private Integer quantity;
    private List<Event> events = new ArrayList<Event>();

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
}