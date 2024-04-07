package org.poo.cb.Exceptions;

public class NotAFriend extends CommandException {
  public NotAFriend(String emailFriend) {
    super("You are not allowed to transfer money to " + emailFriend);
  }
}
