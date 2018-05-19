package command.search;

public class SearchBookByPropertyArgument {
    private final String prefix;
    private final String argument;

    public SearchBookByPropertyArgument(String prefix, String argument) {
        this.prefix = prefix;
        this.argument = argument;
    }

    public static SearchBookByPropertyArgument fromString(String argument) {
        String prefix = argument.substring(0, 2);
        String value = argument.substring(2);

        return new SearchBookByPropertyArgument(prefix, value);
    }

    public String getArgument() {
        return this.argument;
    }

    public String getPrefix() {
        return this.prefix;
    }
}
