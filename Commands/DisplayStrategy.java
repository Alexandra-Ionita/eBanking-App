package org.poo.cb.Commands;

import org.poo.cb.Exceptions.CommandException;

public interface DisplayStrategy {
  void display() throws CommandException;
}
