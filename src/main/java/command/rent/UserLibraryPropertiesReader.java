package command.rent;

import core.UserInputReader;
import libraryuser.LibraryUser;

public class UserLibraryPropertiesReader {

    private final UserInputReader userInputReader = new UserInputReader();

    public LibraryUser readArgumentsFromUser() {
        return new LibraryUser(readFirstName(), readLastName());
    }

    private String readFirstName() {
        System.out.println("Firstname: ");
        return userInputReader.getUserInput();
    }

    private String readLastName() {
        System.out.println("Lastname: ");
        return userInputReader.getUserInput();
    }
}
