package org.example.mid_sda_q1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.util.List;

public class i222420_Q1_editResultController {
    @FXML private TableView<i222420_Q1_Book> booksTable;
    @FXML private TableColumn<i222420_Q1_Book, String> titleColumn;
    @FXML private TableColumn<i222420_Q1_Book, String> authorColumn;
    @FXML private TableColumn<i222420_Q1_Book, String> isbnColumn;

    public void initialize() {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("bookAuthor"));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bookISBN"));
        loadBooks();

        //returning the double click selected row
        booksTable.setRowFactory(tv -> {
            TableRow<i222420_Q1_Book> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    i222420_Q1_Book selectedBook = row.getItem();
                    openEditBookDialog(selectedBook);
                }
            });
            return row;
        });
    }

    private void loadBooks(){
        List<i222420_Q1_Book> bookList = i222420_Q1_bookService.getInstance().getBooks();
        ObservableList<i222420_Q1_Book> obsBooks = FXCollections.observableArrayList(bookList);
        booksTable.setItems(obsBooks);
    }


    private void openEditBookDialog(i222420_Q1_Book book) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("i222420_Q1_editBookDialogue.fxml"));  // Adjust path as necessary
            Parent root = loader.load();

            i222420_Q1_editBookController controller = loader.getController();
            controller.loadBookData(book);

            Stage stage = new Stage();
            stage.setTitle("Edit Book");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            loadBooks();  // reload the books table after editing
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
