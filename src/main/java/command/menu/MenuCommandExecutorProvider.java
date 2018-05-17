package command.menu;

import command.CommandExecutor;
import command.add.AddNewBookCommandExecutor;
import command.exit.ExitCommandExecutor;

public class MenuCommandExecutorProvider {

    private CommandExecutor addNewBookCommandExecutor = new AddNewBookCommandExecutor();
    private ExitCommandExecutor exitCommandExecutor = new ExitCommandExecutor();

    public CommandExecutor getExecutor(MenuCommand menuCommand) {
        if(menuCommand.getName().equals("1")) {
            return addNewBookCommandExecutor;
        }
        if(menuCommand.getName().equals("Q")) {
            return exitCommandExecutor;
        }
        throw new RuntimeException("Wrong menu choice: " + menuCommand.getName());
    }
}
