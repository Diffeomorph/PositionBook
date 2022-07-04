package com.example.PositionBook.Services;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {
    @JsonProperty("ID")
    private String id;
    @JsonProperty("ID")
    private String action;
    @JsonProperty("ID")
    private String account;
    @JsonProperty("ID")
    private String security;
    @JsonProperty("ID")
    private int quantity;

    public Event(){

    }

    public String getId(){
        return id;
    }

    public void setId(String ID){
        this.id = id;
    }

    public String getAction(){
        return Action;
    }

    public void setAction(String Action){
        this.Action = Action;
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

    public void setQuantity(Double quantity){
        this.quantity = quantity;
    }

}
