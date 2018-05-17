package menu;

import java.util.ArrayList;
import java.util.List;

public class MenuChoices {

    public static final String MENU_COMMAND_ADD_BOOK = "1: Add book.";
    public static final String MENU_COMMAND_DELETE_BOOK= "2: Delete book.";
    public static final String MENU_COMMAND_SEARCH_BOOK_BY_PROPERTY = "3: Search book by name, author or ISBN number.";
    public static final String MENU_COMMAND_SEARCH_BOOK_BY_TIME_UNRENTED = "4: Search book by time being unrented.";
    public static final String MENU_COMMAND_RENT_BOOK = "5: Rent book.";
    public static final String MENU_COMMAND_PRINT_READERS_REPORT = "6: Print readers report.";
    public static final String MENU_COMMAND_EXIT = "Q: Exit.";

    private final List<String> menuChoicesCommands = new ArrayList<>();

    public MenuChoices() {
        menuChoicesCommands.add(MENU_COMMAND_ADD_BOOK);
        menuChoicesCommands.add(MENU_COMMAND_DELETE_BOOK);
        menuChoicesCommands.add(MENU_COMMAND_SEARCH_BOOK_BY_PROPERTY);
        menuChoicesCommands.add(MENU_COMMAND_SEARCH_BOOK_BY_TIME_UNRENTED);
        menuChoicesCommands.add(MENU_COMMAND_RENT_BOOK);
        menuChoicesCommands.add(MENU_COMMAND_PRINT_READERS_REPORT);
        menuChoicesCommands.add(MENU_COMMAND_EXIT);
    }

    public List<String> getMenuChoicesCommands() {
        return menuChoicesCommands;
    }
}
