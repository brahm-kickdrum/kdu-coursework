package org.example;
import java.time.LocalDate;
public class Book {
    private String title;
    private String isbn;
    private boolean checkedOut;
    private LocalDate returnDate = null;
    private String genre;

    public Book(String title, String isbn, boolean checkedOut, String genre) {
        this.title = title;
        this.isbn = isbn;
        this.checkedOut = checkedOut;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}