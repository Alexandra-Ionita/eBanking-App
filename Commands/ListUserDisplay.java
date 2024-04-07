package org.poo.cb.Commands;

import org.poo.cb.EBankingApplicationManager;
import org.poo.cb.Entities.User;
import org.poo.cb.Exceptions.UserDoesNotExist;

public class ListUserDisplay implements DisplayStrategy {
  private final String email;

  public ListUserDisplay(String email) {
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
      System.out.print("\"email\": \"" + user.getEmail() + "\",");
      System.out.print("\"firstname\": \"" + user.getName() + "\",");
      System.out.print("\"lastname\": \"" + user.getSurname() + "\",");
      System.out.print("\"address\": \"" + user.getAddress() + "\",");
      System.out.print("\"friends\": [");

      int i = 0;
      for (String friend : user.getFriends().keySet()) {
        if (i == user.getFriends().size() - 1) {
          System.out.print("\"" + friend + "\"");
        } else {
          System.out.print("\"" + friend + "\",");
        }
        i++;
      }

      System.out.print("]");
      System.out.println("}");
    }

  }
}
