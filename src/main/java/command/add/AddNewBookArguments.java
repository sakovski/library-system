package command.add;

public class AddNewBookArguments {
    private final String title;
    private final String author;
    private final String isbnNumber;

    public AddNewBookArguments(String title, String author, String isbnNumber) {
        this.title = title;
        this.author = author;
        this.isbnNumber = isbnNumber;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getIsbnNumber() {
        return this.isbnNumber;
    }
}
