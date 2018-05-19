package libraryuser;

import book.Book;

public class LibraryUserService {

    private final LibraryUserRepository libraryUserRepository = new LibraryUserRepository();
    private final LibraryUserFactory libraryUserFactory = new LibraryUserFactory();

    public void saveBookForLibraryUser(LibraryUser libraryUserProperties, Book book) {
        LibraryUser libraryUserCandidate = libraryUserRepository.getUserFromRepository(libraryUserProperties.getFirstname(), libraryUserProperties.getLastname())
                .orElse(createNewLibraryUser(libraryUserProperties.getFirstname(), libraryUserProperties.getLastname()));
        libraryUserRepository.addBookToLibraryUser(libraryUserCandidate, book);
    }

    private LibraryUser createNewLibraryUser(String firstname, String lastname) {
        LibraryUser newLibraryUser = libraryUserFactory.createUser(firstname, lastname);
        return libraryUserRepository.save(newLibraryUser);
    }

}
