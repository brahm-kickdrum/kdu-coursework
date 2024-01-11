package org.example.question4;

import org.example.LoggerFile;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    private static final LoggerFile log = new LoggerFile();

    /**
     * treeSetDemo function take comparator as an argument and orders the book objects accordingly.
     *
     * @param comparator
     */
    public static void treeSetDemo(Comparator<Book> comparator) {
        Book book1 = new Book("Harry Potter", "J.K.Rowling", 1997);
        Book book2 = new Book("Walden", "Henry David Thoreau", 1854);
        Book book3 = new Book("Effective Java", "Joshua Bloch", 2008);
        Book book4 = new Book("The Last Lecture", "Randy Pausch", 2008);

        Set<Book> books = new TreeSet<>(comparator);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        for (Book book : books) {
            log.logInfo("Book : " + book.getTitle() + " Author : " + book.getAuthor() + " Year : " + book.getYear());
        }
    }

    public static void main(String[] args) {
        log.logInfo("\nBooks in Normal Order");
        treeSetDemo(null);
        log.logInfo("\nBooks in Ascending Order");
        treeSetDemo(new PubDataAscComparator());
        log.logInfo("\nBooks in Descending Order");
        treeSetDemo(new PubDataDscComparator());
    }
}