package command.exit;

import command.CommandExecutor;

public class ExitCommandExecutor implements CommandExecutor {

    @Override
    public void execute(String command) {
        System.out.println("Bye!");
        System.exit(0);
    }
}
