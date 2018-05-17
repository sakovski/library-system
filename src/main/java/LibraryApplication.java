import menu.MenuPrinter;

public class LibraryApplication {

    private final MenuPrinter menuPrinter = new MenuPrinter();

    public void run() {
        menuPrinter.printMenu();
    }
}
