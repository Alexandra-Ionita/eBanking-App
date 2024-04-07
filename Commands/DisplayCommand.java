package org.poo.cb.Commands;

import org.poo.cb.Entities.CommandInput;
import org.poo.cb.Exceptions.CommandException;

public class DisplayCommand implements Command {
  public DisplayCommand(final CommandInput commandInput) {
    super();
  }

  @Override
  public void execute(CommandInput commandInput) {
    DisplayContext context = new DisplayContext();

    switch (commandInput.commandType) {
      case "LIST USER" -> context.setStrategy(new ListUserDisplay(commandInput.email));
      case "LIST PORTFOLIO" -> context.setStrategy(new ListPortfolioDisplay(commandInput.email));
      case "RECOMMEND STOCKS" ->
              context.setStrategy(new RecommendedStocksStrategy());
    }

    try {
      context.executeDisplay();
    } catch (CommandException e) {
      System.out.println(e.getMessage());
    }
  }
}
