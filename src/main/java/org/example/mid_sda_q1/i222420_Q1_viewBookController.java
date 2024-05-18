package org.example.mid_sda_q1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.List;
import javafx.beans.property.ReadOnlyStringWrapper;


public class i222420_Q1_viewBookController {
    @FXML
    private TableView<i222420_Q1_Book> booksTable;
    @FXML
    private TableColumn<i222420_Q1_Book, String> titleColumn;
    @FXML
    private TableColumn<i222420_Q1_Book, String> authorColumn;
    @FXML
    private TableColumn<i222420_Q1_Book, String> isbnColumn;
    @FXML
    private TableColumn<i222420_Q1_Book, String> availabilityColumn;

    @FXML
    public void initialize(){

        titleColumn.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("bookAuthor"));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bookISBN"));
        availabilityColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper("Available"));

        loadBooks();
    }

    @FXML
    private void loadBooks(){
        List<i222420_Q1_Book> bookList = i222420_Q1_bookService.getInstance().getBooks();
        ObservableList<i222420_Q1_Book> obsBooks = FXCollections.observableArrayList(bookList); //observable list allows listeners to track changes when they occur
        booksTable.setItems(obsBooks);
    }
}
