package com.example.PositionBook.Services;

public class Event {
    private String id;
    private String action;
    private String account;
    private String security;
    private Double quantity;

    public String getAccount(){
        return account;
    }

    public String getSecurity(){
        return security;
    }
}
