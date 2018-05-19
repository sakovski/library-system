package report.library_users;

public class LibraryUserReportPrinter {

    public void printReport(LibraryUserReport libraryUserReport) {
        System.out.println(libraryUserReport.getHeader());
        if(libraryUserReport.hasDetails()) {
            libraryUserReport.getDetails().forEach(System.out::println);
        }
    }
}
