package command.search;

public class SearchBooksByWeeksUntrentedArgumentParser {

    public int parseUserInput(String input) {
        return toInteger(input);
    }

    private int toInteger(String input) {
        try
        {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException ex)
        {
           throw new RuntimeException("Given input has to be positive integer number!");
        }
    }
}
