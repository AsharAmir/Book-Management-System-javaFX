package org.example.mid_sda_q1;
import javafx.beans.property.SimpleStringProperty;

public class i222420_Q1_Book {
    private SimpleStringProperty  bookTitle; //SimpleStringProperty is used to bind the data to the TableView
    private SimpleStringProperty  bookAuthor;
    private SimpleStringProperty  bookISBN;
    private boolean isAvailable;

    public i222420_Q1_Book(String booktitle, String bookAuthor, String bookISBN, boolean isAvailable) {
        this.bookTitle = new SimpleStringProperty(booktitle);
        this.bookAuthor = new SimpleStringProperty(bookAuthor);
        this.bookISBN = new SimpleStringProperty(bookISBN);
        this.isAvailable = isAvailable;
    }

    public String getBookTitle() {
        return bookTitle.get();
    }

    public SimpleStringProperty bookTitleProperty() {
        return bookTitle;
    }

    public void setBookTitle(String booktitle) {
        this.bookTitle.set(booktitle);
    }

    public String getBookAuthor() {
        return bookAuthor.get();
    }

    public SimpleStringProperty bookAuthorProperty() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor.set(bookAuthor);
    }

    public String getBookISBN() {
        return bookISBN.get();
    }

    public SimpleStringProperty bookISBNProperty() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN.set(bookISBN);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "booktitle=" + bookTitle +
                ", bookAuthor=" + bookAuthor +
                ", bookISBN=" + bookISBN +
                ", isAvailable=" + isAvailable +
                '}';
    }

}
