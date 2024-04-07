package org.poo.cb.Exceptions;

public class InsufficientTransfer extends CommandException {
  public InsufficientTransfer(String currency) {
    super("Insufficient amount in account " + currency + " for transfer");
  }
}
