package org.poo.cb.Entities;

import org.poo.cb.Currency.Currency;

public class Account {
  private final Currency currency;
  private double amount;

  public Currency getCurrency() {
    return currency;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public Account(Currency currency) {
    this.currency = currency;
  }
}
