package command.exit;

import command.CommandExecutor;

public class ExitCommandExecutor implements CommandExecutor {

    @Override
    public void execute() {
        System.out.println("Bye!");
        System.exit(0);
    }
}
