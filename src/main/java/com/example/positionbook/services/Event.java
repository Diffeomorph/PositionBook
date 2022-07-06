package com.example.positionbook.services;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
A class to store each trade event and its associated data
*/

public class Event {
    @JsonProperty("ID")
    private int id;
    @JsonProperty("Action")
    private String action;
    @JsonProperty("Account")
    private String account;
    @JsonProperty("Security")
    private String security;
    @JsonProperty("Quantity")
    private int quantity;

    public Event(){

    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getAction(){
        return action;
    }

    public void setAction(String action){
        this.action = action;
    }

    public String getAccount(){
        return account;
    }

    public void setAccount(String account){
        this.account = account;
    }

    public String getSecurity(){
        return security;
    }

    public void setSecurity(String security){
        this.security = security;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

}
