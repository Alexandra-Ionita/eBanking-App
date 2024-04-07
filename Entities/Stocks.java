package org.poo.cb.Entities;

import java.util.ArrayList;

public class Stocks {
  private String companyName;
  private final ArrayList<Double> prices = new ArrayList<>();
  private double currentPrice;

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public ArrayList<Double> getPrices() {
    return prices;
  }

  public double getCurrentPrice() {
    return currentPrice;
  }

  public void setCurrentPrice(double currentPrice) {
    this.currentPrice = currentPrice;
  }
}
