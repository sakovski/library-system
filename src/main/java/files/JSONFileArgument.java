package files;

public class JSONFileArgument {

    private final String bookTitle;
    private final String bookAuthor;
    private final String bookIsbnNumber;
    private final boolean isBookRented;
    private final String lastLibraryUserFirstname;
    private final String lastLibraryUserLastname;
    private final int lastDateRentedYear;
    private final int lastDateRentedMonth;
    private final int lastDateRentedDay;

    public JSONFileArgument(String bookTitle, String bookAuthor, String bookIsbnNumber, boolean isBookRented, String lastLibraryUserFirstname, String lastLibraryUserLastname, int lastDateRentedYear, int lastDateRentedMonth, int lastDateRentedDay) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookIsbnNumber = bookIsbnNumber;
        this.isBookRented = isBookRented;
        this.lastLibraryUserFirstname = lastLibraryUserFirstname;
        this.lastLibraryUserLastname = lastLibraryUserLastname;
        this.lastDateRentedYear = lastDateRentedYear;
        this.lastDateRentedMonth = lastDateRentedMonth;
        this.lastDateRentedDay = lastDateRentedDay;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookIsbnNumber() {
        return bookIsbnNumber;
    }

    public boolean isBookRented() {
        return isBookRented;
    }

    public String getLastLibraryUserFirstname() {
        return lastLibraryUserFirstname;
    }

    public String getLastLibraryUserLastname() {
        return lastLibraryUserLastname;
    }

    public int getLastDateRentedYear() {
        return lastDateRentedYear;
    }

    public int getLastDateRentedMonth() {
        return lastDateRentedMonth;
    }

    public int getLastDateRentedDay() {
        return lastDateRentedDay;
    }
}
