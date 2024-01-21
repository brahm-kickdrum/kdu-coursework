package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Book 1", "ISBN1", false, "Fiction");
        Book book2 = new Book("Book 2", "ISBN2", false, "Fiction");
        Book book3 = new Book("Book 3", "ISBN3", false, "Romance");
        Book book4 = new Book("Book 4", "ISBN4", false, "Non fiction");
        Book book5 = new Book("Book 5", "ISBN5", false, "Thriller");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        Author author1 = new Author("Author1", Arrays.asList(book1, book3, book5));
        library.addAuthor(author1);
        Author author2 = new Author("Author2", Arrays.asList(book2, book4));
        library.addAuthor(author2);

        Patron patron1 = new Patron("Patron1", 3, Arrays.asList());
        library.addPatron(patron1);
        Patron patron2 = new Patron("Patron2", 3, Arrays.asList());
        library.addPatron(patron2);

        LoggerFile.logInfo("All Available Books:");
        library.findAllAvailableBooks();

        library.checkOutBook(book1, patron1);
        library.findBooksByAuthor(author1);
        library.findOverdueBooks().forEach(b -> LoggerFile.logInfo("Book: " + b.getTitle()));

        library.addBookToMap(book1.getTitle());
        library.addBookToMap(book1.getTitle());
        library.addBookToMap(book2.getTitle());
        library.addBookToMap(book3.getTitle());
        library.findPopularBooks(2).forEach(LoggerFile::logInfo);

        library.groupBooksByGenre().forEach((genre, books) -> {
            LoggerFile.logInfo("Genre: " + genre);
            books.forEach(b -> LoggerFile.logInfo("   Book: " + b.getTitle()));
        });
    }
}

