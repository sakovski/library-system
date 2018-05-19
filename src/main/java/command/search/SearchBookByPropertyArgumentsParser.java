package command.search;

public class SearchBookByPropertyArgumentsParser {

    public SearchBookByPropertyArgument parseUserArgument(String argument) {
        if(argument.length() < 3) {
            throw new RuntimeException("Missing argument!");
        }
        return SearchBookByPropertyArgument.fromString(argument);
    }
}
