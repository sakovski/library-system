package report.library_users;

import library_user.LibraryUser;

import java.util.List;
import java.util.stream.Collectors;

public class LibraryUserReportFactory {

    private static final String DETAIL_ROW = "%s - %s";

    public LibraryUserReport createReport(List<LibraryUser> users) {
        if(users.size() == 0) {
            return LibraryUserReport.emptyReport();
        }
        List<String> details = getDetails(users);
        return LibraryUserReport.filledReport(details);
    }

    private List<String> getDetails(List<LibraryUser> users) {
        return users.stream()
                .map(l -> String.format(DETAIL_ROW, l.getFullInfo(), l.getRentedBooks().size()))
                .collect(Collectors.toList());
    }
}
