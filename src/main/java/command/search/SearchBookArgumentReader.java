package command.search;

import core.UserInputReader;

public class SearchBookArgumentReader {

    private final UserInputReader userInputReader = new UserInputReader();

    public String readArgumentsFromUser() {
        return userInputReader.getUserInput();
    }
}
