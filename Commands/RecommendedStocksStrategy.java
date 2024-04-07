package org.poo.cb.Commands;

import org.poo.cb.EBankingApplicationManager;

import java.util.Iterator;

public class RecommendedStocksStrategy implements DisplayStrategy {
  @Override
  public void display() {
    EBankingApplicationManager manager =
            EBankingApplicationManager.getInstance();

    System.out.print("{");
    System.out.print("\"stocksToBuy\": [");

    Iterator<String> it = manager.getRecommendedStocks().iterator();
    while (it.hasNext()) {
      System.out.print("\"" + it.next() + "\"");
      if (it.hasNext()) {
        System.out.print(",");
      }
    }

    System.out.print("]");
    System.out.println("}");
  }
}
