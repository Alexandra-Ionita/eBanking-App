package org.poo.cb.Commands;

import org.poo.cb.EBankingApplicationManager;
import org.poo.cb.Entities.CommandInput;
import org.poo.cb.Entities.User;
import org.poo.cb.Exceptions.AlreadyAFriend;
import org.poo.cb.Exceptions.CommandException;
import org.poo.cb.Exceptions.UserDoesNotExist;

public class AddFriend implements Command {
  public AddFriend(final CommandInput commandInput) {
    super();
  }
  @Override
  public void execute(CommandInput commandInput) throws CommandException {
    EBankingApplicationManager manager =
            EBankingApplicationManager.getInstance();

    if (!manager.getUsers().containsKey(commandInput.emailUser)) {
      throw new UserDoesNotExist(commandInput.emailUser);
    } else if (!manager.getUsers().containsKey(commandInput.emailFriend)) {
      throw new UserDoesNotExist(commandInput.emailFriend);
    } else {
      User user = manager.getUsers().get(commandInput.emailUser);
      User friend = manager.getUsers().get(commandInput.emailFriend);

      if (user.getFriends().containsKey(commandInput.emailFriend)) {
        throw new AlreadyAFriend(commandInput.emailFriend);
      } else {
        user.getFriends().put(commandInput.emailFriend, friend);
        friend.getFriends().put(commandInput.emailUser, user);
      }
    }
  }
}
