package org.poo.cb.Currency;

import java.util.HashMap;
import java.util.Map;

public class CurrencyFactory {
  private static final Map<String, Currency> currencies = new HashMap<>();

  public static Currency getCurrency(String currencyType) {
    if (!currencies.containsKey(currencyType)) {
      switch (currencyType) {
        case "CAD" -> currencies.put(currencyType, new CADCurrency());
        case "USD" -> currencies.put(currencyType, new USDCurrency());
        case "EUR" -> currencies.put(currencyType, new EURCurrency());
        case "GBP" -> currencies.put(currencyType, new GBPCurrency());
        case "JPY" -> currencies.put(currencyType, new JPYCurrency());
        default -> throw new IllegalArgumentException("Unknown currency type: " + currencyType);
      }
    }
    return currencies.get(currencyType);
  }
}

