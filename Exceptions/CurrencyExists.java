package org.poo.cb.Exceptions;

public class CurrencyExists extends CommandException {
  public CurrencyExists(String currency) {
    super("Account in currency " + currency + " already exists for user");
  }
}
