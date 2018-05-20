package command.rent;

public class RentBookArguments {

    private final String title;
    private final String author;

    public RentBookArguments(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }
}
