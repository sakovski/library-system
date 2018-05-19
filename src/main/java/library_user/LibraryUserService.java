package library_user;

import book.Book;

import java.util.List;
import java.util.stream.Collectors;

public class LibraryUserService {

    private final LibraryUserRepository libraryUserRepository = new LibraryUserRepository();
    private final LibraryUserFactory libraryUserFactory = new LibraryUserFactory();

    public void saveBookForLibraryUser(LibraryUser libraryUserProperties, Book book) {
        LibraryUser libraryUserCandidate = libraryUserRepository.getUserFromRepository(libraryUserProperties.getFirstname(), libraryUserProperties.getLastname())
                .orElseGet(() -> createNewLibraryUser(libraryUserProperties.getFirstname(), libraryUserProperties.getLastname()));
        libraryUserRepository.addBookToLibraryUser(libraryUserCandidate, book);
    }

    public List<LibraryUser> getAllUsersWithRentedBooks() {
        List<LibraryUser> test = libraryUserRepository.getLibraryUsers();
                //.filter(l -> l.getAmountOfRentedBooks() > 0)
               // .collect(Collectors.toList());
        return test;
    }

    private LibraryUser createNewLibraryUser(String firstname, String lastname) {
        LibraryUser newLibraryUser = libraryUserFactory.createUser(firstname, lastname);
        return libraryUserRepository.save(newLibraryUser);
    }

}
