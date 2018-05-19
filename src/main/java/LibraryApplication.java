import command.CommandExecutor;
import command.menu.MenuCommandExecutorProvider;
import core.UserInputReader;
import menu.MenuPrinter;

public class LibraryApplication {

    private MenuPrinter menuPrinter = new MenuPrinter();
    private UserInputReader userInputReader = new UserInputReader();
    private MenuCommandExecutorProvider menuCommandExecutorProvider = new MenuCommandExecutorProvider();

    public void run() {
        menuPrinter.printWelcomeMessage();

        while (true) {
            try {
                menuPrinter.printMenu();
                String userInput = userInputReader.getUserInput();
                CommandExecutor commandExecutor = menuCommandExecutorProvider.getExecutor(userInput);
                commandExecutor.execute(userInput);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
