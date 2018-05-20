package core;

import book.Book;
import book.BookService;
import files.JSONFileArgument;
import files.JSONFileParser;
import files.JSONFileWriter;

import java.util.List;

public class LibrarySaver {

    private final JSONFileWriter jsonFileWriter = new JSONFileWriter();
    private final JSONFileParser jsonFileParser = new JSONFileParser();
    private final BookService bookService = new BookService();

    public void saveBookCatalogueToJsonFile(String filePath) {
        List<Book> books = bookService.getAllBooks();
        List<JSONFileArgument> jsonFileArguments = jsonFileParser.readFromBooksToJSONFileArguments(books);
        jsonFileWriter.writeToJsonFile(jsonFileArguments, filePath);
    }

}
