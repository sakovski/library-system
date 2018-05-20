import command.CommandExecutor;
import command.menu.MenuCommandExecutorProvider;
import core.UserInputReader;
import menu.MenuPrinter;

public class LibraryApplication {

    private MenuPrinter menuPrinter = new MenuPrinter();
    private UserInputReader userInputReader = new UserInputReader();
    private MenuCommandExecutorProvider menuCommandExecutorProvider = new MenuCommandExecutorProvider();
    private LibraryInitializer libraryInitializer = new LibraryInitializer();

    public void run(String[] arguments) {
        System.out.println(arguments[0]);
        libraryInitializer.initializeFromFilePath(arguments[0]);
        menuPrinter.printWelcomeMessage();

        while (true) {
            try {
                menuPrinter.printMenu();
                String userInput = userInputReader.getUserInput();
                CommandExecutor commandExecutor = menuCommandExecutorProvider.getExecutor(userInput);
                commandExecutor.execute();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
