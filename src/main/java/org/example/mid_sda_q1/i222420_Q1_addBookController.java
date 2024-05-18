package org.example.mid_sda_q1;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;


public class i222420_Q1_addBookController {
    @FXML
    private TextField titleTextField;

    @FXML
    private TextField authorTextField;

    @FXML
    private TextField isbnTextField;

    @FXML
    private Button addButton;

    @FXML
    private Label errorLabel;

    @FXML
    public void initialize() { //initializer is called everytime an instnance is created of addBook
        System.out.println("Add Book Controller Initialized");
        addButton.setDisable(true); //disable the add button until all fields are validated
        //errorLabel.setText(" ");
        titleTextField.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        authorTextField.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        isbnTextField.textProperty().addListener((observable, oldValue, newValue) -> validateFields());

        //mapping add button
        addButton.setOnAction(event -> addBook());
    }

    @FXML
    private void validateFields() {
        boolean isTitleEmpty = titleTextField.getText().isEmpty();
        boolean isAuthorEmpty = authorTextField.getText().isEmpty();
        boolean isISBNEmpty = isbnTextField.getText().isEmpty();
        //regex format for validation of ISBN
        boolean isISBNValid = isbnTextField.getText().matches("\\d{9}[\\dX]");
        addButton.setDisable(isTitleEmpty || isAuthorEmpty || isISBNEmpty || !isISBNValid); //enable the button if validated

    }

    @FXML
    private void clearFields(){
        titleTextField.clear();
        authorTextField.clear();
        isbnTextField.clear();
    }

    @FXML
    private void showErrorDialog(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void showSuccessDialog(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void addBook(){
        System.out.println("Add Book action clicked!");
        String title = titleTextField.getText();
        String author = authorTextField.getText();
        String isbn = isbnTextField.getText();
        i222420_Q1_Book tempBook = new i222420_Q1_Book(title, author, isbn, true);
        if(i222420_Q1_bookService.getInstance().isISBN_duplicated(isbn)){ //disallowing repeat isbn, but allowing repeat title and author
            System.out.println("ISBN already exists");
            showErrorDialog("ISBN already exists. Please use a unique ISBN for each book.");
            return;
        }
        i222420_Q1_bookService.getInstance().addBook(tempBook); //getting the instance since singleton
        System.out.println("Book added: " + tempBook);
        showSuccessDialog("Book added successfully.");
        clearFields();

        //also show all books added yet
        System.out.println("Books added yet: ");
        for(i222420_Q1_Book b: i222420_Q1_bookService.getInstance().getBooks()){
            System.out.println(b);
        }
    }

}



