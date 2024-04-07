package org.poo.cb.Currency;

import java.util.ArrayList;

public abstract class Currency {
  public abstract ArrayList<Double> getExchangeRates();
  public abstract double getUSDExchangeRate();
  public abstract double getEURExchangeRate();
  public abstract double getGBPExchangeRate();
  public abstract double getJPYExchangeRate();
  public abstract double getCADExchangeRate();
  public abstract double getMXNExchangeRate(String currency);
}
