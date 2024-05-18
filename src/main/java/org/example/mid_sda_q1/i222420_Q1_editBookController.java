package org.example.mid_sda_q1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class i222420_Q1_editBookController {
    @FXML private TextField editTitleTextField;
    @FXML private TextField editAuthorTextField;
    @FXML private TextField editIsbnTextField;

    private i222420_Q1_Book currentBook;
    private final i222420_Q1_bookService bS = i222420_Q1_bookService.getInstance();

    public void loadBookData(i222420_Q1_Book book) {
        this.currentBook = book;
        editTitleTextField.setText(book.getBookTitle());
        editAuthorTextField.setText(book.getBookAuthor());
        editIsbnTextField.setText(book.getBookISBN());
    }

    //to vlaidate before confirming edit
    @FXML
    private boolean validateFields(){
        boolean isTitleEmpty = editTitleTextField.getText().isEmpty();
        boolean isAuthorEmpty = editAuthorTextField.getText().isEmpty();
        boolean isISBNEmpty = editIsbnTextField.getText().isEmpty();
        //check if isbn valid format
        boolean isISBNValid = editIsbnTextField.getText().matches("\\d{9}[\\dX]");
        if(isTitleEmpty || isAuthorEmpty || isISBNEmpty || !isISBNValid){
            return false;
        }else{
            return true;
        }
    }

    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSuccessDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void saveChanges() {

        //check if valid
        if(!validateFields()){
            showErrorDialog("Please fill in all fields correctly");
            return;
        }
        currentBook.setBookTitle(editTitleTextField.getText().trim());
        currentBook.setBookAuthor(editAuthorTextField.getText().trim());
        currentBook.setBookISBN(editIsbnTextField.getText().trim());

        bS.updateBook(currentBook);
        showSuccessDialog("Book updated successfully");

        Stage stage = (Stage) editTitleTextField.getScene().getWindow();
        stage.close();  // Close the edit dialog
    }
}
