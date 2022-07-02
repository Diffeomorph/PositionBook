package com.example.PositionBook.Services;

import com.sun.source.tree.Tree;

import java.util.TreeMap;

public class PositionBook {
    final TreeMap<Double, TradingAccount> accounts;

    public PositionBook(TreeMap accounts){
        this.accounts = new TreeMap();
    }
}
