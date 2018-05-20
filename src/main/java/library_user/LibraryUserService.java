package library_user;

import book.Book;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LibraryUserService {

    private final LibraryUserRepository libraryUserRepository = new LibraryUserRepository();
    private final LibraryUserFactory libraryUserFactory = new LibraryUserFactory();

    public void saveBookForLibraryUser(LibraryUser libraryUserProperties, Book book) {
        LibraryUser libraryUserCandidate = getUserFromRepository(libraryUserProperties.getFirstname(), libraryUserProperties.getLastname())
                .orElseGet(() -> createNewLibraryUser(libraryUserProperties.getFirstname(), libraryUserProperties.getLastname()));
        libraryUserRepository.addBookToLibraryUser(libraryUserCandidate, book);
    }

    public List<LibraryUser> getAllUsersWithRentedBooks() {
        return libraryUserRepository.getLibraryUsers().stream()
                .filter(l -> l.getRentedBooks().size() > 0)
                .filter(l -> !l.getFirstname().equals("NONE"))
                .filter(l -> !l.getLastname().equals("NONE"))
                .collect(Collectors.toList());
    }
    public Optional<LibraryUser> getUserFromRepository(String firstname, String lastname) {
        return libraryUserRepository.getUserFromRepository(firstname, lastname);
    }

    public LibraryUser createNewLibraryUser(String firstname, String lastname) {
        LibraryUser newLibraryUser = libraryUserFactory.createUser(firstname, lastname);
        return libraryUserRepository.save(newLibraryUser);
    }

}
