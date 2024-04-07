package org.poo.cb;

import org.poo.cb.Commands.Command;
import org.poo.cb.Entities.CommandInput;
import org.poo.cb.Entities.Stocks;
import org.poo.cb.Entities.User;
import org.poo.cb.Exceptions.CommandException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class EBankingApplicationManager {
  private static EBankingApplicationManager instance = null;
  private final ArrayList<CommandInput> commands;
  private final HashMap<String, User> users;
  private final HashMap<String, Stocks> stocks;
  private final HashSet<String> recommendedStocks;

  public ArrayList<CommandInput> getCommands() {
    return commands;
  }

  public HashMap<String, User> getUsers() {
    return users;
  }

  public HashMap<String, Stocks> getStocks() {
    return stocks;
  }

  public HashSet<String> getRecommendedStocks() {
    return recommendedStocks;
  }

  private EBankingApplicationManager() {
    users = new HashMap<>();
    commands = new ArrayList<>();
    stocks = new HashMap<>();
    recommendedStocks = new HashSet<>();
  }

  public static EBankingApplicationManager getInstance() {
    if (instance == null) {
      instance = new EBankingApplicationManager();
    }
    return instance;
  }

  public void executeCommand(Command command, CommandInput commandInput) {
    try {
      command.execute(commandInput);
    } catch (CommandException e) {
      System.out.println(e.getMessage());
    }
  }
}
