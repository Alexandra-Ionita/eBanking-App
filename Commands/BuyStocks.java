package org.poo.cb.Commands;

import org.poo.cb.EBankingApplicationManager;
import org.poo.cb.Entities.CommandInput;
import org.poo.cb.Entities.Stocks;
import org.poo.cb.Entities.User;
import org.poo.cb.Exceptions.InsufficientForStocks;

public class BuyStocks implements Command {
  public BuyStocks(final CommandInput commandInput) {
    super();
  }
  @Override
  public void execute(CommandInput commandInput) throws InsufficientForStocks {
    EBankingApplicationManager manager =
            EBankingApplicationManager.getInstance();

    User user = manager.getUsers().get(commandInput.email);
    double userAmount =
            user.getPortfolio().getAccounts().get("USD").getAmount();
    Stocks stock = manager.getStocks().get(commandInput.companyName);
    double stockPrice = stock.getCurrentPrice() * commandInput.noOfStocks;

    if (user.getPremium()) {
      if (manager.getRecommendedStocks().contains(commandInput.companyName)) {
        stockPrice = stockPrice * 0.95;
      }
    }

    if (userAmount < stockPrice) {
      throw new InsufficientForStocks();
    } else {
      user.getPortfolio().getStocks().put(commandInput.companyName,
              commandInput.noOfStocks);
      user.getPortfolio().getAccounts().get("USD").setAmount(
              userAmount - stockPrice);
    }
  }
}
