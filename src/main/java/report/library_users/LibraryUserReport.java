package report.library_users;

import java.util.List;

import static java.util.Collections.emptyList;

public class LibraryUserReport {

    public static final String USERS_NOT_FOUND_HEADER = "There are no users with rented books.";
    public static final String USERS_FOUND_HEADER = "Users with rented books:";

    private final String header;
    private final List<String> details;

    private LibraryUserReport(String header, List<String> details) {
        this.header = header;
        this.details = details;
    }

    public static LibraryUserReport emptyReport() {
        return new LibraryUserReport(USERS_NOT_FOUND_HEADER, emptyList());
    }

    public static LibraryUserReport filledReport(List<String> details) {
        return new LibraryUserReport(USERS_FOUND_HEADER, details);
    }

    public boolean hasDetails() {
        return !details.isEmpty();
    }

    public String getHeader() {return this.header;}

    public List<String> getDetails() {
        return details;
    }
}
