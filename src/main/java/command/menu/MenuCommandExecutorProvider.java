package command.menu;

import command.CommandExecutor;
import command.add.AddNewBookExecutor;

public class MenuCommandExecutorProvider {

    private CommandExecutor addNewBookExecutor = new AddNewBookExecutor();

    public CommandExecutor getExecutor(MenuCommand menuCommand) {
        if(menuCommand.getName().equals("1")) {
            return addNewBookExecutor;
        }
        throw new RuntimeException("Wrong menu choice: " + menuCommand.getName());
    }
}
