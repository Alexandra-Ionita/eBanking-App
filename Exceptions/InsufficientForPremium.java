package org.poo.cb.Exceptions;

public class InsufficientForPremium extends CommandException {
  public InsufficientForPremium() {
    super("Insufficient amount in account for buying premium option");
  }
}
