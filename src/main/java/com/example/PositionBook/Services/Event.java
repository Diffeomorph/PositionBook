package com.example.PositionBook.Services;

public class Event {
    private String ID;
    private String Action;
    private String Account;
    private String Security;
    private int Quantity;

    public Event(){

    }

    public String getId(){
        return ID;
    }

    public void setId(String ID){
        this.ID = ID;
    }

    public String getAction(){
        return Action;
    }

    public void setAction(String Action){
        this.Action = Action;
    }

    public String getAccount(){
        return Account;
    }

    public void setAccount(String Account){
        this.Account = Account;
    }

    public String getSecurity(){
        return Security;
    }

    public void setSecurity(String Security){
        this.Security = Security;
    }

    public int getQuantity(){
        return Quantity;
    }

    public void setQuantity(Double quantity){
        this.Quantity = Quantity;
    }

}
