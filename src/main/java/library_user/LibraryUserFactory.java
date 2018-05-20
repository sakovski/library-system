package library_user;

public class LibraryUserFactory {

    LibraryUser createUser(String firstname, String lastname) {
        return new LibraryUser(firstname, lastname);
    }
}
