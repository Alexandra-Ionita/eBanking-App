package org.poo.cb.Exceptions;

public class UserDoesNotExist extends CommandException {
  public UserDoesNotExist(String email) {
    super("User with email " + email + " doesn't exist");
  }
}
