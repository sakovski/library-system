package core;

import book.Book;
import book.BookService;
import files.JSONFileArguments;
import files.JSONFileParser;
import library_user.LibraryUser;
import library_user.LibraryUserService;

import java.time.LocalDate;
import java.util.List;

public class LibraryInitializer {

    private final JSONFileParser jsonFileParser = new JSONFileParser();
    private final BookService bookService = new BookService();
    private final LibraryUserService libraryUserService = new LibraryUserService();

    public void initializeFromFilePath(String filePath) {
        List<JSONFileArguments> newBooks = jsonFileParser.readFromFileToJSONFileArguments(filePath);
        newBooks.forEach(b -> {
            LibraryUser libraryUser = libraryUserService.getUserFromRepository(b.getLastLibraryUserFirstname(), b.getLastLibraryUserLastname())
                    .orElseGet(() -> libraryUserService.createNewLibraryUser(b.getLastLibraryUserFirstname(), b.getLastLibraryUserLastname()));
            Book newBook = bookService.addBookFromFileToRepository(
                    b.getBookTitle(),
                    b.getBookAuthor(),
                    b.getBookIsbnNumber(),
                    b.isBookRented(),
                    libraryUser,
                    LocalDate.of(b.getLastDateRentedYear(), b.getLastDateRentedMonth(), b.getLastDateRentedDay()));
            if(newBook.isRented) {
                libraryUserService.saveBookForLibraryUser(libraryUser, newBook);
            }
        });
    }
}

