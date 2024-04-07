package org.poo.cb.Exceptions;

public class AlreadyAFriend extends CommandException {
  public AlreadyAFriend(String emailFriend) {
    super("User with email " + emailFriend + " is already a friend");
  }
}
