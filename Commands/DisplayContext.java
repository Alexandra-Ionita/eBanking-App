package org.poo.cb.Commands;

import org.poo.cb.Exceptions.CommandException;

public class DisplayContext {
  private DisplayStrategy strategy;

  public void setStrategy(DisplayStrategy strategy) {
    this.strategy = strategy;
  }

  public void executeDisplay() throws CommandException {
    strategy.display();
  }
}

