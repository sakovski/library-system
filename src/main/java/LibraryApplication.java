import command.CommandExecutor;
import core.LibraryInitializer;
import core.LibrarySaver;
import command.menu.MenuCommandExecutorProvider;
import core.UserInputReader;
import menu.MenuPrinter;

public class LibraryApplication {

    private MenuPrinter menuPrinter = new MenuPrinter();
    private UserInputReader userInputReader = new UserInputReader();
    private MenuCommandExecutorProvider menuCommandExecutorProvider = new MenuCommandExecutorProvider();
    private LibraryInitializer libraryInitializer = new LibraryInitializer();
    private final LibrarySaver librarySaver = new LibrarySaver();

    public void run(String[] arguments) {

        final String libraryCataloguePath = arguments[0];
        try{
            libraryInitializer.initializeFromFilePath(libraryCataloguePath);
            System.out.println("Library catalogue loaded!");
        } catch(Exception e) {
            System.out.println("Library catalogue not loaded! " + e.getMessage());
        }

        menuPrinter.printWelcomeMessage();

        while (true) {
            try {
                menuPrinter.printMenu();
                String userInput = userInputReader.getUserInput();
                CommandExecutor commandExecutor = menuCommandExecutorProvider.getExecutor(userInput);
                commandExecutor.execute();
                librarySaver.saveBookCatalogueToJsonFile(libraryCataloguePath);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
