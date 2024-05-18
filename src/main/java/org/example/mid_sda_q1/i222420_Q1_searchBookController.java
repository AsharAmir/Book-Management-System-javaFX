package org.example.mid_sda_q1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class i222420_Q1_searchBookController {
    @FXML
    private TextField titleTextField;
    @FXML
    private TextField authorTextField;
    @FXML
    private TextField isbnTextField;
    @FXML
    private Button searchButton;

    private i222420_Q1_bookService bookService = i222420_Q1_bookService.getInstance(); //getting the instance of the created book because singleton

    @FXML
    public void initialize() {
        searchButton.setDisable(true); //grey out intiially
        titleTextField.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        authorTextField.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        isbnTextField.textProperty().addListener((observable, oldValue, newValue) -> validateFields()); //using a lambda expression to validate the fields

    }

    private void validateFields(){
        boolean areFieldsEmpty = titleTextField.getText().trim().isEmpty() && authorTextField.getText().trim().isEmpty() && isbnTextField.getText().trim().isEmpty();
        searchButton.setDisable(areFieldsEmpty);
    }

    @FXML
    private void handleSearchQuery() throws IOException{
        System.out.println("Search Books action clicked!");
        String title = titleTextField.getText().trim();
        String author = authorTextField.getText().trim();
        String isbn = isbnTextField.getText().trim();

        List<i222420_Q1_Book> results = bookService.getBooks().stream()
                .filter(book -> book.getBookTitle().contains(title))
                .filter(book -> book.getBookAuthor().contains(author))
                .filter(book -> book.getBookISBN().contains(isbn))
                .collect(Collectors.toList()); //collecting the results in a list

        //debug for result, display it in console
        results.forEach(System.out::println);


        //displaying in a new frame
        FXMLLoader loader = new FXMLLoader(getClass().getResource("i222420_Q1_searchResults.fxml"));
        Parent root = loader.load();

        i222420_Q1_searchResultController searchResultController = loader.getController();
        searchResultController.setResults(results);

        Stage sg = new Stage();
        sg.setScene(new Scene(root));
        sg.setTitle("Search Results");
        sg.show();
    }
}

