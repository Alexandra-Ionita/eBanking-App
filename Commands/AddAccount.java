package org.poo.cb.Commands;

import org.poo.cb.Currency.Currency;
import org.poo.cb.Currency.CurrencyFactory;
import org.poo.cb.EBankingApplicationManager;
import org.poo.cb.Entities.Account;
import org.poo.cb.Entities.CommandInput;
import org.poo.cb.Entities.User;
import org.poo.cb.Exceptions.CurrencyExists;

public class AddAccount implements Command {
  public AddAccount(final CommandInput commandInput) {
    super();
  }

  @Override
  public void execute(CommandInput commandInput) throws CurrencyExists {
    EBankingApplicationManager manager =
            EBankingApplicationManager.getInstance();

    User user = manager.getUsers().get(commandInput.email);
    Currency currency = CurrencyFactory.getCurrency(commandInput.currency);
    Account account = new Account(currency);

    if (user.getPortfolio().getAccounts().containsKey(commandInput.currency)) {
      throw new CurrencyExists(commandInput.currency);
    } else {
      user.getPortfolio().getAccounts().put(commandInput.currency, account);
    }

  }
}
