package org.poo.cb.Commands;

import org.poo.cb.Currency.Currency;
import org.poo.cb.Currency.CurrencyFactory;
import org.poo.cb.EBankingApplicationManager;
import org.poo.cb.Entities.CommandInput;
import org.poo.cb.Entities.User;
import org.poo.cb.Exceptions.InsufficientAmount;

public class ExchangeMoney implements Command {
  public ExchangeMoney(final CommandInput commandInput) {
    super();
  }
  @Override
  public void execute(CommandInput commandInput) throws InsufficientAmount {
    EBankingApplicationManager manager =
            EBankingApplicationManager.getInstance();

    User user = manager.getUsers().get(commandInput.email);

    double accAmount =
            user.getPortfolio().getAccounts().get(commandInput.sourceCurrency).getAmount();
    Currency currency =
            CurrencyFactory.getCurrency(commandInput.destinationCurrency);
    double exchangeRate = currency.getMXNExchangeRate(commandInput.sourceCurrency);
    double neededAmount = commandInput.amount * exchangeRate;

    if (accAmount < neededAmount) {
      throw new InsufficientAmount(commandInput.sourceCurrency);
    } else {
      if (neededAmount > accAmount / 2.0 && !user.getPremium()) {
        user.getPortfolio().getAccounts().get(commandInput.sourceCurrency).setAmount(accAmount - neededAmount / 100.0);
      }
      accAmount =
              user.getPortfolio().getAccounts().get(commandInput.sourceCurrency).getAmount();
      user.getPortfolio().getAccounts().get(commandInput.sourceCurrency).setAmount(accAmount - neededAmount);
      user.getPortfolio().getAccounts().get(commandInput.destinationCurrency).setAmount(
              user.getPortfolio().getAccounts().get(commandInput.destinationCurrency).getAmount() + commandInput.amount);
    }
  }
}
