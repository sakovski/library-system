package command.add;

import core.UserInputReader;

public class AddNewBookArgumentsReader {

    private final UserInputReader userInputReader = new UserInputReader();

    public AddNewBookArguments readArgumentsFromUser() {
        return new AddNewBookArguments(readTitle(), readAuthor(), readIsbnNumber());
    }

    private String readAuthor() {
        System.out.println("Author: ");
        return userInputReader.getUserInput();
    }

    private String readIsbnNumber() {
        System.out.println("ISBN number: ");
        return userInputReader.getUserInput();
    }

    private String readTitle() {
        System.out.println("Title: ");
        return userInputReader.getUserInput();
    }
}
