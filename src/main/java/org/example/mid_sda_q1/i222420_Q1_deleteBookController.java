package org.example.mid_sda_q1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.List;

public class i222420_Q1_deleteBookController {
    @FXML
    private TableView<i222420_Q1_Book> booksTable;
    @FXML
    private TableColumn<i222420_Q1_Book, String> titleColumn;
    @FXML
    private TableColumn<i222420_Q1_Book, String> authorColumn;
    @FXML
    private TableColumn<i222420_Q1_Book, String> isbnColumn;
    @FXML private Button deleteButton;

    @FXML
    public void initialize(){
        //setcellvaluefactory is used because we are using a custom object to populate individual cells in the column
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("bookAuthor"));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bookISBN"));

        //handling double clicks, and then returns the selected row
        booksTable.setRowFactory(tv -> {
            TableRow<i222420_Q1_Book> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    booksTable.getSelectionModel().select(row.getIndex());
                    deleteButton.setDisable(false);
                }
            });
            return row;
        });
        loadBooks();
    }

    @FXML
    private void loadBooks(){
        List<i222420_Q1_Book> bookList = i222420_Q1_bookService.getInstance().getBooks();
        ObservableList<i222420_Q1_Book> obsBooks = FXCollections.observableArrayList(bookList);
        booksTable.setItems(obsBooks);
    }

    @FXML
    private void handleDeleteAction(ActionEvent event) throws IOException {
        i222420_Q1_Book selectedBook = booksTable.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            i222420_Q1_bookService.deleteBook(selectedBook);  // Implement this method in your BookService to remove a book
            loadBooks(); // Reload the updated list
            deleteButton.setDisable(true); // Disable the delete button again

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book deleted successfully.");
            alert.showAndWait();

            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("i222420_Q1_hello-view.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Main View");
            stage.show();
        }
    }


}

