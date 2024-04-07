package org.poo.cb.Currency;

import java.util.ArrayList;

public class USDCurrency extends Currency {
  public ArrayList<Double> exchangeRates = new ArrayList<>();

  public ArrayList<Double> getExchangeRates() {
    return exchangeRates;
  }

  @Override
  public double getUSDExchangeRate() {
    return getExchangeRates().get(4);
  }

  @Override
  public double getEURExchangeRate() {
    return getExchangeRates().get(0);
  }

  @Override
  public double getGBPExchangeRate() {
    return getExchangeRates().get(1);
  }

  @Override
  public double getJPYExchangeRate() {
    return getExchangeRates().get(2);
  }

  @Override
  public double getCADExchangeRate() {
    return getExchangeRates().get(3);
  }

  @Override
  public double getMXNExchangeRate(String currency) {
    switch (currency) {
      case "USD":
        return getUSDExchangeRate();
      case "EUR":
        return getEURExchangeRate();
      case "GBP":
        return getGBPExchangeRate();
      case "JPY":
        return getJPYExchangeRate();
      case "CAD":
        return getCADExchangeRate();
      default:
        return 0;
    }
  }

}
