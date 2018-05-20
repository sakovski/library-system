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
        try{
            libraryInitializer.initializeFromFilePath(arguments[0]);
        } catch(Exception e) {
            System.out.println("Library file not loaded! " + e.getMessage());
        }

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
