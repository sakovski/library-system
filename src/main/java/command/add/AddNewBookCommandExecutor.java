package command.add;

import book.BookService;
import command.CommandExecutor;
import command.arguments.AddDeleteBookArguments;

public class AddNewBookCommandExecutor implements CommandExecutor {

    private final AddDeleteBookArgumentsReader addNewBookArgumentsReader = new AddDeleteBookArgumentsReader();
    private final BookService bookService = new BookService();

    @Override
    public void execute() {
        System.out.println("*New book creator*");
        AddDeleteBookArguments addNewBookArguments = addNewBookArgumentsReader.readArgumentsFromUser();
        bookService.addNewBookToRepository(addNewBookArguments.getTitle(), addNewBookArguments.getAuthor(), addNewBookArguments.getIsbnNumber());
    }
}
