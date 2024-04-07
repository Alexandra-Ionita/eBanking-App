package org.poo.cb.Exceptions;

public class UserExistsException extends CommandException {
  public UserExistsException(String email) {
    super("User with " + email + " already exists");
  }
}
