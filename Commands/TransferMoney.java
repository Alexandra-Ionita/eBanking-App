package org.poo.cb.Commands;

import org.poo.cb.EBankingApplicationManager;
import org.poo.cb.Entities.CommandInput;
import org.poo.cb.Entities.User;
import org.poo.cb.Exceptions.CommandException;
import org.poo.cb.Exceptions.InsufficientTransfer;
import org.poo.cb.Exceptions.NotAFriend;

public class TransferMoney implements Command {
  public TransferMoney(final CommandInput commandInput) {
    super();
  }
  @Override
  public void execute(CommandInput commandInput) throws CommandException {
    EBankingApplicationManager manager =
            EBankingApplicationManager.getInstance();

    User user = manager.getUsers().get(commandInput.emailUser);
    User friend = manager.getUsers().get(commandInput.emailFriend);
    double userAmount =
            user.getPortfolio().getAccounts().get(commandInput.currency).getAmount();
    if (userAmount < commandInput.amount) {
      throw new InsufficientTransfer(commandInput.currency);
    } else {
      if (user.getFriends().containsKey(commandInput.emailFriend)) {
        double friendAmount =
                friend.getPortfolio().getAccounts().get(commandInput.currency).getAmount();
        user.getPortfolio().getAccounts().get(commandInput.currency).setAmount(userAmount - commandInput.amount);
        friend.getPortfolio().getAccounts().get(commandInput.currency).setAmount(friendAmount + commandInput.amount);
      } else {
        throw new NotAFriend(commandInput.emailFriend);
      }
    }

  }
}
