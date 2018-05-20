package command.delete;

import book.BookService;
import command.CommandExecutor;
import command.arguments.AddDeleteBookArguments;
import command.add.AddDeleteBookArgumentsReader;

public class DeleteBookCommandExecutor implements CommandExecutor {

    private final AddDeleteBookArgumentsReader deleteBookArgumentsReader = new AddDeleteBookArgumentsReader();
    private final BookService bookService = new BookService();

    @Override
    public void execute() {
        System.out.println("*Delete Book*");
        AddDeleteBookArguments deleteBookArguments = deleteBookArgumentsReader.readArgumentsFromUser();
        bookService.removeFromRepository(deleteBookArguments.getTitle(), deleteBookArguments.getAuthor(), deleteBookArguments.getIsbnNumber());
        System.out.println("All books with given data deleted");
    }
}
