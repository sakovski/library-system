package command.rent;

import core.UserInputReader;
import library_user.LibraryUser;

public class LibraryUserPropertiesReader {

    private final UserInputReader userInputReader = new UserInputReader();

    public LibraryUser readArgumentsFromUser() {
        return new LibraryUser(readFirstName(), readLastName());
    }

    private String readFirstName() {
        System.out.println("Firstname: ");
        return userInputReader.getUserInput().trim();
    }

    private String readLastName() {
        System.out.println("Lastname: ");
        return userInputReader.getUserInput().trim();
    }
}
