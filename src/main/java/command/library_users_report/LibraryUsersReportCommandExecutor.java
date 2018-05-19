package command.library_users_report;

import command.CommandExecutor;
import library_user.LibraryUser;
import library_user.LibraryUserService;
import report.library_users.LibraryUserReportService;

import java.util.List;

public class LibraryUsersReportCommandExecutor implements CommandExecutor {

    private final LibraryUserReportService libraryUserReportService = new LibraryUserReportService();
    private final LibraryUserService libraryUserService = new LibraryUserService();

    @Override
    public void execute() {
        List<LibraryUser> usersWithRentedBooks = libraryUserService.getAllUsersWithRentedBooks();
        libraryUserReportService.printReport(usersWithRentedBooks);
    }
}
