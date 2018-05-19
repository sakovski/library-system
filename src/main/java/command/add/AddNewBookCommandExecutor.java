package command.add;

import book.BookService;
import command.CommandExecutor;

public class AddNewBookCommandExecutor implements CommandExecutor {

    private final AddDeleteBookArgumentsReader addNewBookArgumentsReader = new AddDeleteBookArgumentsReader();
    private final BookService bookService = new BookService();

    @Override
    public void execute(String command) {
        System.out.println("*New book creator*");
        AddDeleteBookArguments addNewBookArguments = addNewBookArgumentsReader.readArgumentsFromUser();
        bookService.addToRepository(addNewBookArguments.getTitle(), addNewBookArguments.getAuthor(), addNewBookArguments.getIsbnNumber());
    }
}
