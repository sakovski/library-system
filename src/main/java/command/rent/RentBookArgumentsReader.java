package command.rent;

import command.arguments.RentBookArguments;
import core.UserInputReader;

public class RentBookArgumentsReader {

    private final UserInputReader userInputReader = new UserInputReader();

    public RentBookArguments readArgumentsFromUser() {
        return new RentBookArguments(readTitle(), readAuthor());
    }

    private String readTitle() {
        System.out.println("Title: ");
        return userInputReader.getUserInput();
    }

    private String readAuthor() {
        System.out.println("Author: ");
        return userInputReader.getUserInput();
    }
}
