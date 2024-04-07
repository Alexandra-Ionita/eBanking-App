package org.poo.cb.Entities;

public class CommandInput {
  public String commandType;
  public String email;
  public String name;
  public String surname;
  public String address;
  public String currency;
  public String emailUser;
  public String emailFriend;
  public double amount;
  public String sourceCurrency;
  public String destinationCurrency;
  public String companyName;
  public int noOfStocks;

  public static class Builder {
    private final String commandType;
    private String email;
    private String name;
    private String surname;
    private String address;
    private String currency;
    private String emailUser;
    private String emailFriend;
    private double amount;
    private String sourceCurrency;
    private String destinationCurrency;
    private String companyName;
    private int noOfStocks;

    public Builder(String commandType) {
      this.commandType = commandType;
    }

    public Builder email(String email) {
      this.email = email;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder surname(String surname) {
      this.surname = surname;
      return this;
    }

    public Builder address(String address) {
      this.address = address;
      return this;
    }

    public Builder currency(String currency) {
      this.currency = currency;
      return this;
    }

    public Builder emailUser(String emailUser) {
      this.emailUser = emailUser;
      return this;
    }

    public Builder emailFriend(String emailFriend) {
      this.emailFriend = emailFriend;
      return this;
    }

    public Builder amount(double amount) {
      this.amount = amount;
      return this;
    }

    public Builder sourceCurrency(String sourceCurrency) {
      this.sourceCurrency = sourceCurrency;
      return this;
    }

    public Builder destinationCurrency(String destinationCurrency) {
      this.destinationCurrency = destinationCurrency;
      return this;
    }

    public Builder companyName(String companyName) {
      this.companyName = companyName;
      return this;
    }

    public Builder noOfStocks(int noOfStocks) {
      this.noOfStocks = noOfStocks;
      return this;
    }

    public CommandInput build() {
      return new CommandInput(this);
    }
  }

  private CommandInput(Builder builder) {
    commandType = builder.commandType;
    email = builder.email;
    name = builder.name;
    surname = builder.surname;
    address = builder.address;
    currency = builder.currency;
    emailUser = builder.emailUser;
    emailFriend = builder.emailFriend;
    amount = builder.amount;
    sourceCurrency = builder.sourceCurrency;
    destinationCurrency = builder.destinationCurrency;
    companyName = builder.companyName;
    noOfStocks = builder.noOfStocks;
  }
}
