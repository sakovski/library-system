import core.UserInputReader;
import menu.MenuPrinter;

public class LibraryApplication {

    private final MenuPrinter menuPrinter = new MenuPrinter();
    private final UserInputReader userInputReader = new UserInputReader();

    public void run() {
        menuPrinter.printWelcomeMessage();
        
        do {
            try {
                menuPrinter.printMenu();
                String userInput = userInputReader.getUserInput();

            } catch(Exception e) {
                System.out.println(e.getMessage());
            }

        } while(true);

    }
}
