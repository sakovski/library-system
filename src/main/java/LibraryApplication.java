import command.CommandExecutor;
import command.menu.MenuCommand;
import command.menu.MenuCommandExecutorProvider;
import core.UserInputReader;
import menu.MenuPrinter;

public class LibraryApplication {

    private MenuPrinter menuPrinter = new MenuPrinter();
    private UserInputReader userInputReader = new UserInputReader();
    private MenuCommandExecutorProvider menuCommandExecutorProvider = new MenuCommandExecutorProvider();

    public void run() {
        menuPrinter.printWelcomeMessage();

        do {
            try {
                menuPrinter.printMenu();
                String userInput = userInputReader.getUserInput();
                MenuCommand menuCommand = new MenuCommand(userInput);
                CommandExecutor<MenuCommand> menuCommandExecutor = menuCommandExecutorProvider.getExecutor(menuCommand);
                menuCommandExecutor.execute(menuCommand);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }

        } while(true);

    }
}
