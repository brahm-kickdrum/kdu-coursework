package org.example;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Patron> patrons = new ArrayList<>();
    private List<Book> checkedOutBooks = new ArrayList<>();
    private HashMap<String, Integer> booksMap = new HashMap<>();
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void removeAuthor(Author author) {
        authors.remove(author);
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public void removePatron(Patron patron) {
        patrons.remove(patron);
    }

    public void addToCheckedOutBooks(Book book) {
        checkedOutBooks.add(book);
    }

    public void removeFromCheckedOutBooks(Book book) {
        checkedOutBooks.remove(book);
    }

    public void addBookToMap(String bookTitle) {
        int currentCount = booksMap.getOrDefault(bookTitle, 0);
        booksMap.put(bookTitle, currentCount + 1);
    }

    /**
     * findAllAvailableBooks function logs all the books that are available and can be borrowed.
     */
    public void findAllAvailableBooks() {
        books.forEach(b -> LoggerFile.logInfo("Book : " + b.getTitle() + " ISBN : " + b.getIsbn() ));
    }

    /**
     * checkOutBook is used to borrow book from library
     * @param book
     * @param patron
     */
    public void checkOutBook(Book book, Patron patron){
        if(books.contains(book)){
            if(patrons.contains(patron)){
                if(patron.getCheckedOutBooks().size() < patron.getCheckoutLimit()){
                    Optional<Book> optionalBook = books.stream()
                            .filter(b -> !b.isCheckedOut())
                            .findFirst();
                    if(optionalBook.isPresent()){
                        Book b = optionalBook.get();
                        b.setCheckedOut(true);
                        b.setReturnDate(LocalDate.now().plusDays(14));
                        addToCheckedOutBooks(b);
                        addBookToMap(b.getTitle());

                        LoggerFile.logInfo("Book is checked out successfully.");
                    }
                    else{
                        LoggerFile.logError("The book is not available for checkout.");
                    }
                }
                else{
                    LoggerFile.logError("Checkout limit for the patron has exceeded.");
                }
            }
            else{
                LoggerFile.logError("Patron does not exists.");
            }
        }
        else{

            LoggerFile.logError("Book does not exists.");
        }
    }

    /**
     * findBooksByAuthor function finds books written by an author
     * @param author
     */
    public void findBooksByAuthor(Author author) {

        Author a = authors.stream()
                .filter(a1 -> a1.getName().equals(author.getName()))
                .findFirst()
                .orElse(null);
        if (a != null) {
            a.getBooks().forEach(a1 -> LoggerFile.logInfo("Book : " + a1.getTitle()));
        } else {
            LoggerFile.logError("Author does not exist.");
        }
    }

    /**
     * findOverdueBooks function finds the books that are not returned on the due date.
     * @return List of Book objects
     */
    public List<Book> findOverdueBooks(){
        return checkedOutBooks.stream()
                .filter(b -> b.getReturnDate().isBefore(LocalDate.now()))
                .toList();
    }

    /**
     * findPopularBooks function lists top n popular books
     * @param n
     * @return List of String
     */
    public List<String> findPopularBooks(int n) {
        return booksMap.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .map(Map.Entry::getKey)
                .limit(n)
                .toList();
    }

    /**
     * groupBooksByGenre function returns all the books corresponding to a genre
     * @return map of genre and list of books with that genre
     */
    public Map<String, List<Book>> groupBooksByGenre() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre));
    }
}


