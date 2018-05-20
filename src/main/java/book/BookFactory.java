package book;

import library_user.LibraryUser;

import java.time.LocalDate;

public class BookFactory {
    private final IsbnValidator isbnValidator = new IsbnValidator();

    public Book createBook(String title, String author, String isbnNumber) {
        if(isbnValidator.isIsbnNumberValid(isbnNumber)) {
            System.out.println("Book created!");
            return new Book(title, author, isbnNumber);
        }
        throw new RuntimeException("Given ISBN number is not valid!");
    }

    public Book createExistingBook(String title, String author, String isbnNumber, boolean isRented, LibraryUser lastUser, LocalDate dateLastRented) {
        if(isbnValidator.isIsbnNumberValid(isbnNumber)) {
            return new Book(title, author, isbnNumber, isRented, lastUser, dateLastRented);
        }
        throw new RuntimeException("Given ISBN number is not valid!");
    }
}
