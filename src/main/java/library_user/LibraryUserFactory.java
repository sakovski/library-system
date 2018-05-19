package library_user;

public class LibraryUserFactory {

    LibraryUser createUser(String firstname, String lastname) {
        System.out.println("Library user does not exist. Registering new user.");
        return new LibraryUser(firstname, lastname);
    }
}
