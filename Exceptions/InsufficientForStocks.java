package org.poo.cb.Exceptions;

public class InsufficientForStocks extends CommandException {
  public InsufficientForStocks() {
    super("Insufficient amount in account for buying stock");
  }
}
