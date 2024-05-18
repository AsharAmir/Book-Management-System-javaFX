package org.example.mid_sda_q1;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class i222420_Q1_searchResultController { //CONTROLLER TO display the search returned result in tabular form

    @FXML
    private TableView<i222420_Q1_Book> resultsTable;
    @FXML
    private TableColumn<i222420_Q1_Book, String> titleColumn;
    @FXML
    private TableColumn<i222420_Q1_Book, String> authorColumn;
    @FXML
    private TableColumn<i222420_Q1_Book, String> isbnColumn;

    public void initialize() {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("bookAuthor"));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bookISBN"));
    }

    public void setResults(List<i222420_Q1_Book> results) {
        resultsTable.getItems().setAll(results);
    }
}
