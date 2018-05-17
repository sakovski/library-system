package command.exit;

import command.CommandExecutor;
import command.menu.MenuCommand;

public class ExitCommandExecutor implements CommandExecutor<MenuCommand> {

    @Override
    public void execute(MenuCommand command) {
        System.out.println("Bye!");
        System.exit(0);
    }
}
