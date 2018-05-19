package library_user;

import book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibraryUserRepository {

    private static final List<LibraryUser> libraryUsers = new ArrayList<>();

    public Optional<LibraryUser> getUserFromRepository(String firstname, String lastname) {
        return libraryUsers.stream()
                .filter(l -> l.getFirstname().equals(firstname))
                .filter(l -> l.getLastname().equals(lastname))
                .findFirst();
    }

    public LibraryUser save(LibraryUser libraryUser) {
        libraryUsers.add(libraryUser);
        return libraryUser;
    }

    public List<LibraryUser> getLibraryUsers() {
        return libraryUsers;
    }

    public void addBookToLibraryUser(LibraryUser user, Book book) {
        user.getRentedBooks().add(book);
    }
}
