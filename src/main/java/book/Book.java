package book;

import library_user.LibraryUser;

import java.time.LocalDate;

public class Book {

    private final String title;
    private final String author;
    private final String isbnNumber;
    private LocalDate dateLastRent;
    private LibraryUser currentLibraryUser;
    public boolean isRented;

    public Book(String title, String author, String isbnNumber) {
        this.title = title;
        this.author = author;
        this.isbnNumber = isbnNumber;
        dateLastRent = null;
        currentLibraryUser = null;
        isRented = false;
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
        return this.currentLibraryUser;
    }

    public void setCurrentLibraryUser(LibraryUser libraryUser) {
        this.currentLibraryUser = libraryUser;
    }

    public void setDateLastRent(LocalDate date) {
        this.dateLastRent = date;
    }
}
