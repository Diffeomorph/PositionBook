package com.example.PositionBook.Services;

public class Event {
    private String id;
    private String action;
    private String account;
    private String security;
    private Double quantity;

    public Event(){

    }

    public String getId(){
        return id;
    }

    public void setId(String id){
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

    public Double getQuantity(){
        return quantity;
    }

    public void setQuantity(Double quantity){
        this.quantity = quantity;
    }

}
