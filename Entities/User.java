package org.poo.cb.Entities;

import java.util.HashMap;

public class User {
  private final String email;
  private final String name;
  private final String surname;
  private final String address;
  private boolean premium;
  private final Portfolio portfolio = new Portfolio();
  private final HashMap<String, User> friends = new HashMap<>();

  public String getEmail() {
    return email;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getAddress() {
    return address;
  }

  public Portfolio getPortfolio() {
    return portfolio;
  }

  public HashMap<String, User> getFriends() {
    return friends;
  }

  public boolean getPremium() {
    return premium;
  }

  public void setPremium(boolean premium) {
    this.premium = premium;
  }

  public User(String email, String name, String surname, String address) {
    this.email = email;
    this.name = name;
    this.surname = surname;
    this.address = address;
    this.premium = false;
  }
}
