package com.example.PositionBook.Services;

import java.util.*;

public class TradingAccount {
    final String accountName;
    final List<TradeEvent> tradeEvents;

    public TradingAccount(String accountName){
        this.accountName = accountName;
        this.tradeEvents = new ArrayList<>();
    }


}
