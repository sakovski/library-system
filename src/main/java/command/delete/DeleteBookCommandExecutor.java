package command.delete;

import book.BookService;
import command.CommandExecutor;
import command.add.AddDeleteBookArguments;
import command.add.AddDeleteBookArgumentsReader;

public class DeleteBookCommandExecutor implements CommandExecutor {

    private final AddDeleteBookArgumentsReader deleteBookArgumentsReader = new AddDeleteBookArgumentsReader();
    private final BookService bookService = new BookService();

    @Override
    public void execute(String command) {
        System.out.println("*Delete Book*");
        AddDeleteBookArguments deleteBookArguments = deleteBookArgumentsReader.readArgumentsFromUser();
        bookService
    }
}
