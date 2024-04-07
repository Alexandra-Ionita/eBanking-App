package org.poo.cb.Commands;

import org.poo.cb.EBankingApplicationManager;
import org.poo.cb.Entities.User;
import org.poo.cb.Exceptions.UserDoesNotExist;
import java.util.Locale;


public class ListPortfolioDisplay implements DisplayStrategy {
  private final String email;

  public ListPortfolioDisplay(String email) {
    this.email = email;
  }
  @Override
  public void display() throws UserDoesNotExist {
    EBankingApplicationManager manager =
            EBankingApplicationManager.getInstance();

    if (!manager.getUsers().containsKey(email)) {
      throw new UserDoesNotExist(email);
    } else {
      User user = manager.getUsers().get(email);
      System.out.print("{");
      System.out.print("\"stocks\":[");

      int i = 0;
      for (String stock : user.getPortfolio().getStocks().keySet()) {
        System.out.print("{\"stockName\":\"" + stock + "\",");
        System.out.print("\"amount\":" + user.getPortfolio().getStocks().get(stock));


        if (i == user.getPortfolio().getStocks().size() - 1) {
          System.out.print("}");
        } else {
          System.out.print("},");
        }
        i++;
      }

      System.out.print("],");
      System.out.print("\"accounts\":[");

      i = 0;
      for (String account : user.getPortfolio().getAccounts().keySet()) {
        System.out.print("{\"currencyName\":\"" + account + "\",");

        double amount = user.getPortfolio().getAccounts().get(account).getAmount();
        String formattedAmount = String.format(Locale.US, "%.2f", amount);


         System.out.print("\"amount\":\"" + formattedAmount  + "\"");

        if (i == user.getPortfolio().getAccounts().size() - 1) {
          System.out.print("}");
        } else {
          System.out.print("},");
        }
        i++;
      }

      System.out.print("]");
      System.out.println("}");
    }
  }
}
