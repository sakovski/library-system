package command.add;

import book.BookService;
import command.CommandExecutor;

public class AddNewBookCommandExecutor implements CommandExecutor {

    private final AddNewBookArgumentsReader addNewBookArgumentsReader = new AddNewBookArgumentsReader();
    private final BookService bookService = new BookService();

    @Override
    public void execute(String command) {
        System.out.println("*New book creator*");
        AddNewBookArguments addNewBookArguments = addNewBookArgumentsReader.readArgumentsFromUser();
        bookService.addToRepository(addNewBookArguments.getTitle(), addNewBookArguments.getAuthor(), addNewBookArguments.getIsbnNumber());
    }
}
