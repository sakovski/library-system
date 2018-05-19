package libraryuser;

import book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibraryUserRepository {

    private final List<LibraryUser> libraryUsers = new ArrayList<>();

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

    public void addBookToLibraryUser(LibraryUser user, Book book) {

    }

    public void removeBookFromLibraryUser() {

    }

}
