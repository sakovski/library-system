package command.return_book;

import core.UserInputReader;

public class ReturnBookArgumentReader {

    private final UserInputReader userInputReader = new UserInputReader();

    public int getUserInput() {
        System.out.println("Give number: ");
        String userInput = userInputReader.getUserInput();
        try
        {
            return Integer.parseInt(userInput);
        }
        catch (NumberFormatException ex)
        {
           throw new RuntimeException("Given input is not a number!");
        }
    }
}
