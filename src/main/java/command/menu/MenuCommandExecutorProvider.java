package command.menu;

import command.CommandExecutor;
import command.add.AddNewBookCommandExecutor;
import command.delete.DeleteBookCommandExecutor;
import command.exit.ExitCommandExecutor;
import command.library_users_report.LibraryUsersReportCommandExecutor;
import command.rent.RentBookCommandExecutor;
import command.search.SearchBookByPropertyCommandExecutor;
import command.search.SearchBooksByTimeUnrentedCommandExecutor;

public class MenuCommandExecutorProvider {

    private CommandExecutor addNewBookCommandExecutor = new AddNewBookCommandExecutor();
    private CommandExecutor deleteBookCommandExecutor = new DeleteBookCommandExecutor();
    private CommandExecutor searchBookByPropertyCommandExecutor = new SearchBookByPropertyCommandExecutor();
    private CommandExecutor searchBooksByTimeUnrentedCommandExecutor = new SearchBooksByTimeUnrentedCommandExecutor();
    private CommandExecutor rentBookCommandExecutor = new RentBookCommandExecutor();
    private CommandExecutor readersReportCommandExecutor = new LibraryUsersReportCommandExecutor();
    private ExitCommandExecutor exitCommandExecutor = new ExitCommandExecutor();

    public CommandExecutor getExecutor(String userInput) {
        if(userInput.equals("1")) {
            return addNewBookCommandExecutor;
        }
        if(userInput.equals("2")) {
            return deleteBookCommandExecutor;
        }
        if(userInput.equals("3")) {
            return searchBookByPropertyCommandExecutor;
        }
        if(userInput.equals("4")) {
            return searchBooksByTimeUnrentedCommandExecutor;
        }
        if(userInput.equals("5")) {
            return rentBookCommandExecutor;
        }
        if(userInput.equals("6")) {
            return readersReportCommandExecutor;
        }
        if(userInput.equals("Q")) {
            return exitCommandExecutor;
        }
        throw new RuntimeException("Wrong menu choice: " + userInput);
    }
}
