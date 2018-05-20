package book;

import library_user.LibraryUser;

import java.time.LocalDate;

public class Book {

    private final String title;
    private final String author;
    private final String isbnNumber;
    private LocalDate dateLastRent;
    private LibraryUser lastLibraryUser;
    public boolean isRented;

    public Book(String title, String author, String isbnNumber) {
        this.title = title;
        this.author = author;
        this.isbnNumber = isbnNumber;
        dateLastRent = LocalDate.now();
        lastLibraryUser = null;
        isRented = false;
    }

    public Book(String title, String author, String isbnNumber, boolean isRented, LibraryUser lastLibraryUser, LocalDate dateLastRent) {
        this(title, author, isbnNumber);
        this.isRented = isRented;
        this.lastLibraryUser = lastLibraryUser;
        this.dateLastRent = dateLastRent;
    }


    public String getTitle () {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getIsbnNumber() {
        return this.isbnNumber;
    }

    public LocalDate getDateLastRent() {
        return this.dateLastRent;
    }

    public LibraryUser getCurrentLibraryUser() {
        return this.lastLibraryUser;
    }

    public void setCurrentLibraryUser(LibraryUser libraryUser) {
        this.lastLibraryUser = libraryUser;
    }

    public void setDateLastRent(LocalDate date) {
        this.dateLastRent = date;
    }
}
