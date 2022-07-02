package com.example.PositionBook.Services;

public class TradeEvent {
    final String id;
    final String action;
    final String security;
    final Double quantity;

    public TradeEvent(String id, String action, String security, Double quantity){
        this.id = id;
        this.action = action;
        this.security = security;
        this.quantity = quantity;
    }
}
