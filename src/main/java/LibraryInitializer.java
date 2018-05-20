import book.Book;
import book.BookService;
import command.add.AddDeleteBookArguments;
import files.JSONFileParser;

import java.util.List;

public class LibraryInitializer {

    private final JSONFileParser jsonFileParser = new JSONFileParser();
    private final BookService bookService = new BookService();

    public void initializeFromFilePath(String filePath) {
        List<AddDeleteBookArguments> newBooks = jsonFileParser. parseToAddNewBookArguments(filePath);
        newBooks.forEach(b -> bookService.addToRepository(
                b.getTitle(), b.getAuthor(), b.getIsbnNumber()
        ));
    }
}
