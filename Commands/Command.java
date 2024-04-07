package org.poo.cb.Commands;

import org.poo.cb.Entities.CommandInput;
import org.poo.cb.Exceptions.CommandException;

public interface Command {
  void execute(CommandInput commandInput) throws CommandException;
}
