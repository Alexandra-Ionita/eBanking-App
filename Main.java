package org.poo.cb;

import org.poo.cb.Commands.*;
import org.poo.cb.Currency.Currency;
import org.poo.cb.Currency.CurrencyFactory;
import org.poo.cb.Entities.CommandInput;
import org.poo.cb.Entities.Stocks;

import java.io.*;

public class Main {
    public static void reader(String file) {
        EBankingApplicationManager manager =
                EBankingApplicationManager.getInstance();

        BufferedReader br = null;

        try {
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);

            while (true) {
                String command = br.readLine();
                if (command == null) {
                    break;
                }

                String[] commandParts = command.split(" ");
                String commandName =
                        commandParts[0] + " " + commandParts[1];

                switch (commandName) {
                    case "CREATE USER":
                        StringBuilder address = new StringBuilder();
                        for (int i = 5; i < commandParts.length; i++) {
                            if (i == 5) {
                                address = new StringBuilder(commandParts[i]);
                            } else {
                                address.append(" ").append(commandParts[i]);
                            }
                        }
                        CommandInput commandInput = new CommandInput.Builder(
                                commandName)
                                .email(commandParts[2])
                                .name(commandParts[3])
                                .surname(commandParts[4])
                                .address(address.toString())
                                .build();

                        manager.getCommands().add(commandInput);
                        break;

                    case "ADD FRIEND":
                        CommandInput commandInput1 = new CommandInput.Builder(
                                commandName)
                                .emailUser(commandParts[2])
                                .emailFriend(commandParts[3])
                                .build();

                        manager.getCommands().add(commandInput1);
                        break;

                    case "ADD ACCOUNT":
                        CommandInput commandInput2 = new CommandInput.Builder(
                                commandName)
                                .email(commandParts[2])
                                .currency(commandParts[3])
                                .build();

                        manager.getCommands().add(commandInput2);
                        break;

                    case "ADD MONEY":
                        CommandInput commandInput3 = new CommandInput.Builder(
                                commandName)
                                .email(commandParts[2])
                                .currency(commandParts[3])
                                .amount(Double.parseDouble(commandParts[4]))
                                .build();

                        manager.getCommands().add(commandInput3);
                        break;

                    case "EXCHANGE MONEY":
                        CommandInput commandInput4 = new CommandInput.Builder(
                                commandName)
                                .email(commandParts[2])
                                .sourceCurrency(commandParts[3])
                                .destinationCurrency(commandParts[4])
                                .amount(Double.parseDouble(commandParts[5]))
                                .build();

                        manager.getCommands().add(commandInput4);
                        break;

                    case "TRANSFER MONEY":
                        CommandInput commandInput5 = new CommandInput.Builder(
                                commandName)
                                .emailUser(commandParts[2])
                                .emailFriend(commandParts[3])
                                .currency(commandParts[4])
                                .amount(Double.parseDouble(commandParts[5]))
                                .build();

                        manager.getCommands().add(commandInput5);
                        break;

                    case "BUY STOCKS":
                        CommandInput commandInput6 = new CommandInput.Builder(
                                commandName)
                                .email(commandParts[2])
                                .companyName(commandParts[3])
                                .noOfStocks(Integer.parseInt(commandParts[4]))
                                .build();

                        manager.getCommands().add(commandInput6);
                        break;

                    case "RECOMMEND STOCKS":
                        CommandInput commandInput7 = new CommandInput.Builder(
                                commandName)
                                .build();

                        manager.getCommands().add(commandInput7);
                        break;

                    default:
                        CommandInput commandInput9 = new CommandInput.Builder(
                                commandName)
                                .email(commandParts[2])
                                .build();

                        manager.getCommands().add(commandInput9);
                        break;
                }
            }

        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    public static void exchangeRatesReader(String file) {;
        BufferedReader br = null;

        try {
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);

            br.readLine();

            while (true) {
                String exchangeRates = br.readLine();
                if (exchangeRates == null) {
                    break;
                }

                String[] rates = exchangeRates.split(",");
                Currency currency = CurrencyFactory.getCurrency(rates[0]);
                for (int i = 1; i < 6; i++) {
                    currency.getExchangeRates().add(Double.parseDouble(rates[i]));
                }
            }

        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    public static void stocksReader(String file) {
        EBankingApplicationManager manager =
                EBankingApplicationManager.getInstance();

        BufferedReader br = null;

        try {
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);

            br.readLine();

            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }

                Stocks stocks = new Stocks();

                String[] stock = line.split(",");

                stocks.setCompanyName(stock[0]);
                int len = stock.length;

                for (int i = 1; i < len; i++) {
                    stocks.getPrices().add(Double.parseDouble(stock[i]));
                }

                stocks.setCurrentPrice(Double.parseDouble(stock[stock.length - 1]));

                manager.getStocks().put(stock[0], stocks);
            }

        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    public static void executeCommands() {
        EBankingApplicationManager manager =
                EBankingApplicationManager.getInstance();

        for (CommandInput command : manager.getCommands()) {
            switch (command.commandType) {
                case "CREATE USER":
                    Command createUser = new CreateUser(command);
                    manager.executeCommand(createUser, command);
                    break;

                case "ADD FRIEND":
                    Command addFriend = new AddFriend(command);
                    manager.executeCommand(addFriend, command);
                    break;

                case "ADD ACCOUNT":
                    Command addAccount = new AddAccount(command);
                    manager.executeCommand(addAccount, command);
                    break;

                case "ADD MONEY":
                    Command addMoney = new AddMoney(command);
                    manager.executeCommand(addMoney, command);
                    break;

                case "EXCHANGE MONEY":
                    Command exchangeMoney = new ExchangeMoney(command);
                    manager.executeCommand(exchangeMoney, command);
                    break;

                case "TRANSFER MONEY":
                    Command transferMoney = new TransferMoney(command);
                    manager.executeCommand(transferMoney, command);
                    break;

                case "BUY STOCKS":
                    Command buyStocks = new BuyStocks(command);
                    manager.executeCommand(buyStocks, command);
                    break;

                case "RECOMMEND STOCKS":
                    Command recommendStocks = new RecommendStocks(command);
                    manager.executeCommand(recommendStocks, command);
                    break;

                case "BUY PREMIUM":
                    Command buyPremium = new BuyPremium(command);
                    manager.executeCommand(buyPremium, command);
                    break;

                default:
                    Command DisplayCommand = new DisplayCommand(command);
                    manager.executeCommand(DisplayCommand, command);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        if(args == null) {
            System.out.println("Running Main");
        } else {
            String exchange = "src/main/resources/" + args[0];
            String file = "src/main/resources/" + args[1];
            String commands = "src/main/resources/" + args[2];

            exchangeRatesReader(exchange);
            stocksReader(file);
            reader(commands);
            executeCommands();
        }
    }

}