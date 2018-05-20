package library_user;

import book.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryUser {

    private final String firstname;
    private final String lastname;
    private final List<Book> rentedBooks;

    public LibraryUser(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.rentedBooks = new ArrayList<>();
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getFullInfo() {return this.firstname + " " + this.lastname;}

    public List<Book> getRentedBooks() {return this.rentedBooks;}
    }
