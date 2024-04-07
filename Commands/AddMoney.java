package org.poo.cb.Commands;

import org.poo.cb.EBankingApplicationManager;
import org.poo.cb.Entities.CommandInput;
import org.poo.cb.Entities.User;

public class AddMoney implements Command {
  public AddMoney(final CommandInput commandInput) {
    super();
  }
  @Override
  public void execute(CommandInput commandInput) {
    EBankingApplicationManager manager =
            EBankingApplicationManager.getInstance();

    User user = manager.getUsers().get(commandInput.email);
    double sum = user.getPortfolio().getAccounts().get(commandInput.currency).getAmount() + commandInput.amount;
    user.getPortfolio().getAccounts().get(commandInput.currency).setAmount(sum);
  }
}
