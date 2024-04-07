package org.poo.cb.Entities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Portfolio {
  private final LinkedHashMap<String, Account> accounts = new LinkedHashMap<>();
  private final LinkedHashMap<String, Integer> stocks = new LinkedHashMap<>();

  public LinkedHashMap<String, Account> getAccounts() {
    return accounts;
  }

  public LinkedHashMap<String, Integer> getStocks() {
    return stocks;
  }
}
