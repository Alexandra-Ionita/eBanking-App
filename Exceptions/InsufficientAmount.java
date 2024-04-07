package org.poo.cb.Exceptions;

public class InsufficientAmount extends CommandException{
  public InsufficientAmount(String sourceCurrency) {
    super("Insufficient amount in account " + sourceCurrency + " for exchange");
  }
}
