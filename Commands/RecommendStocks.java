package org.poo.cb.Commands;

import org.poo.cb.EBankingApplicationManager;
import org.poo.cb.Entities.CommandInput;
import org.poo.cb.Entities.Stocks;
import org.poo.cb.Exceptions.CommandException;

public class RecommendStocks implements Command {
  public RecommendStocks(final CommandInput commandInput) {
    super();
  }

  @Override
  public void execute(CommandInput commandInput) throws CommandException {
    EBankingApplicationManager manager =
            EBankingApplicationManager.getInstance();

    for (Stocks stock : manager.getStocks().values()) {
      int i = 0;
      double sum10 = 0;
      double sum5 = 0;

      for (Double prices : stock.getPrices()) {
        if (i >= 5 ) {
          sum5 += prices;
        }
        sum10 += prices;
        i++;
      }

      if (sum10 / 10.0 < sum5 / 5.0) {
        manager.getRecommendedStocks().add(stock.getCompanyName());
      }
    }

    Command DisplayCommand = new DisplayCommand(commandInput);
    manager.executeCommand(DisplayCommand, commandInput);
  }

}
