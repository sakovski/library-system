package command.menu;

import command.CommandExecutor;
import command.add.AddNewBookCommandExecutor;
import command.delete.DeleteBookCommandExecutor;
import command.exit.ExitCommandExecutor;
import command.readersReport.ReadersReportCommandExecutor;
import command.rent.RentBookCommandExecutor;
import command.search.SearchBookByPropertyCommandExecutor;
import command.search.SearchBooksByTimeUnrentedCommandExecutor;

public class MenuCommandExecutorProvider {

    private CommandExecutor addNewBookCommandExecutor = new AddNewBookCommandExecutor();
    private CommandExecutor deleteBookCommandExecutor = new DeleteBookCommandExecutor();
    private CommandExecutor searchBookByPropertyCommandExecutor = new SearchBookByPropertyCommandExecutor();
    private CommandExecutor searchBooksByTimeUnrentedCommandExecutor = new SearchBooksByTimeUnrentedCommandExecutor();
    private CommandExecutor rentBookCommandExecutor = new RentBookCommandExecutor();
    private CommandExecutor readersReportCommandExecutor = new ReadersReportCommandExecutor();
    private ExitCommandExecutor exitCommandExecutor = new ExitCommandExecutor();

    public CommandExecutor getExecutor(MenuCommand menuCommand) {
        if(menuCommand.getName().equals("1")) {
            return addNewBookCommandExecutor;
        }
        if(menuCommand.getName().equals("2")) {
            return deleteBookCommandExecutor;
        }
        if(menuCommand.getName().equals("3")) {
            return searchBookByPropertyCommandExecutor;
        }
        if(menuCommand.getName().equals("4")) {
            return searchBooksByTimeUnrentedCommandExecutor;
        }
        if(menuCommand.getName().equals("5")) {
            return rentBookCommandExecutor;
        }
        if(menuCommand.getName().equals("6")) {
            return readersReportCommandExecutor;
        }
        if(menuCommand.getName().equals("Q")) {
            return exitCommandExecutor;
        }
        throw new RuntimeException("Wrong menu choice: " + menuCommand.getName());
    }
}
