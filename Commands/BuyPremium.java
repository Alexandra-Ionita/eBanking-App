package org.poo.cb.Commands;

import org.poo.cb.EBankingApplicationManager;
import org.poo.cb.Entities.CommandInput;
import org.poo.cb.Entities.User;
import org.poo.cb.Exceptions.CommandException;
import org.poo.cb.Exceptions.InsufficientForPremium;
import org.poo.cb.Exceptions.UserDoesNotExist;

public class BuyPremium implements Command {
  public BuyPremium(final CommandInput commandInput) {
    super();
  }

  @Override
  public void execute(CommandInput commandInput) throws CommandException {
    EBankingApplicationManager manager =
            EBankingApplicationManager.getInstance();

    if (manager.getUsers().containsKey(commandInput.email)) {
      User user = manager.getUsers().get(commandInput.email);
      if (user.getPortfolio().getAccounts().get("USD").getAmount() < 100) {
        throw new InsufficientForPremium();
      } else {
        user.getPortfolio().getAccounts().get("USD").setAmount(
                user.getPortfolio().getAccounts().get("USD").getAmount() - 100);
        user.setPremium(true);
      }
    } else {
      throw new UserDoesNotExist(commandInput.email);
    }
  }
}
