package menu;

import java.util.List;

public class MenuPrinter {

    public static final String WELCOME_MESSAGE = "Welcome to Library System!";
    public static final String HEADER_MESSAGE = "Please type a command from command list: ";

    private final MenuChoices menuChoices = new MenuChoices();
    private final StringBuilder stringBuilder = new StringBuilder();

    public void printMenu() {
        stringBuilder.append(HEADER_MESSAGE);
        List<String> menuChoicesCommands = menuChoices.getMenuChoicesCommands();
        menuChoicesCommands.stream()
                .forEach(s -> stringBuilder.append(s).append(System.lineSeparator()));
        System.out.print(stringBuilder.toString());
    }

    public void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }
}
