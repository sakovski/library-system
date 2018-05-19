package command.search;

import core.UserInputReader;

public class SearchBookByPropertyArgumentsReader {

    private final UserInputReader userInputReader = new UserInputReader();

    public String readArgumentsFromUser() {
        return userInputReader.getUserInput();
    }
}
