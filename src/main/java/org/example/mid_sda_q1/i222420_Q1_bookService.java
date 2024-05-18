package org.example.mid_sda_q1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class i222420_Q1_bookService {
    private static final List<i222420_Q1_Book> books = new ArrayList<>(); // List of books

    private static i222420_Q1_bookService instance; // Singleton instance, using this because we want to have only one instance of this class

    private i222420_Q1_bookService() { // Private constructor, so that no one can create an instance of this class
    }

    public static i222420_Q1_bookService getInstance() { // Static method to get the instance of this class
        if (instance == null) {
            instance = new i222420_Q1_bookService();
        }
        return instance;
    }

    public void addBook(i222420_Q1_Book book) { // Method to add a book to the list
        books.add(book);
    }

    public boolean isISBN_duplicated(String isbn) { // Method to check if the ISBN is duplicated
        for (i222420_Q1_Book book : books) {
            if (book.getBookISBN().equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    public static List<i222420_Q1_Book> getBooks() { // Method to get all the books
        return new ArrayList<>(books);
    }

    public void updateBook(i222420_Q1_Book updatedBook) {
        for (i222420_Q1_Book book : books) {
            if (book.getBookISBN().equals(updatedBook.getBookISBN())) {
                book.setBookTitle(updatedBook.getBookTitle());
                book.setBookAuthor(updatedBook.getBookAuthor());
                return;
            }
        }
    }

    public static void deleteBook(i222420_Q1_Book bookToDelete) {
        books.removeIf(book -> Objects.equals(book.getBookISBN(), bookToDelete.getBookISBN()));
    }

}
