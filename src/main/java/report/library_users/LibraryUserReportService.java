package report.library_users;

import library_user.LibraryUser;

import java.util.List;

public class LibraryUserReportService {

    private final LibraryUserReportFactory libraryUserReportFactory = new LibraryUserReportFactory();
    private final LibraryUserReportPrinter libraryUserReportPrinter = new LibraryUserReportPrinter();

    public void printReport(List<LibraryUser> users) {
        LibraryUserReport libraryUserReport = libraryUserReportFactory.createReport(users);
        libraryUserReportPrinter.printReport(libraryUserReport);
    }
}
