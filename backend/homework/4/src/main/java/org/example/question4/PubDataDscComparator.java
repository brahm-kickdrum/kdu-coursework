package org.example.question4;

import java.util.Comparator;

public class PubDataDscComparator implements Comparator<Book> {

    /**
     * compare function compares 2 book objects and sort them in descending order
     *
     * @param book1
     * @param book2
     * @return int
     */
    public int compare(Book book1,Book book2){
        int yearOfComparison = Integer.compare(book1.getYear(),book2.getYear());
        if(yearOfComparison != 0 ) {
            return -yearOfComparison;
        }
        return book1.compareTo(book2);
    }
}