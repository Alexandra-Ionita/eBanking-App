package org.poo.cb.Commands;

import org.poo.cb.EBankingApplicationManager;
import org.poo.cb.Entities.CommandInput;
import org.poo.cb.Entities.User;
import org.poo.cb.Exceptions.UserExistsException;


public class CreateUser implements Command{

  public CreateUser(final CommandInput commandInput) {
    super();
  }

  @Override
  public void execute(CommandInput commandInput) throws UserExistsException {
    User user = new User(commandInput.email, commandInput.name,
            commandInput.surname, commandInput.address);

    EBankingApplicationManager manager =
            EBankingApplicationManager.getInstance();

    if (manager.getUsers().containsKey(commandInput.email)) {
      throw new UserExistsException(commandInput.email);
    } else {
      manager.getUsers().put(commandInput.email, user);
    }
  }
}
