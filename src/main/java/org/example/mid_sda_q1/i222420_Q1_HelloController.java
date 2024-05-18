//THIS IS THE GLOBAL CONTROLLER FOR ALL EVENTS!!!
//ALL THE SUB EVENTS (files named %Form.fxml) ARE HANDLED BY THEIR RESPECTIVE CONTROLLERS

package org.example.mid_sda_q1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class i222420_Q1_HelloController {
    @FXML
    private void handleAddBook(ActionEvent event) throws IOException {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("i222420_Q1_addBook.fxml"));
//            Parent root = loader.load();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.setTitle("Add Book");
//            Stage currentStage = (Stage) root.getScene().getWindow();
//            currentStage.close();
//            stage.show();
//        }catch (IOException e){
//            e.printStackTrace();
//        }

        AnchorPane pane = (AnchorPane) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow().getScene().getRoot();
        Stage stage = (Stage) pane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("i222420_Q1_addBook.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Add Book");
        stage.show();

    }

    @FXML
    private void handleViewAllBooks(ActionEvent event) throws IOException {
        System.out.println("View All Books action clicked!");
        AnchorPane pane = (AnchorPane) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow().getScene().getRoot();
        Stage stage = (Stage) pane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("i222420_Q1_viewBooks.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Add Book");
        stage.show();
    }

    @FXML
    private void handleSearchBooks(ActionEvent event) throws IOException {
        System.out.println("Search Books action clicked!");
        AnchorPane pane = (AnchorPane) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow().getScene().getRoot();
        Stage stage = (Stage) pane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("i222420_Q1_searchBooks.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Add Book");
        stage.show();
    }

    @FXML
    private void handleEditBook(ActionEvent event) throws IOException {
        System.out.println("Edit Book action clicked!");
        AnchorPane pane = (AnchorPane) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow().getScene().getRoot();
        Stage stage = (Stage) pane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("i222420_Q1_editBook.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Add Book");
        stage.show();
    }

    @FXML
    private void handleDeleteBook(ActionEvent event) throws IOException {
        System.out.println("Delete Book action clicked!");
        AnchorPane pane = (AnchorPane) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow().getScene().getRoot();
        Stage stage = (Stage) pane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("i222420_Q1_deleteBook.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Add Book");
        stage.show();
    }


    @FXML
    private void handleNew() throws IOException {
        System.out.println("New action clicked!");
    }

    @FXML
    private void handleOpen() throws IOException {

        System.out.println("Open action clicked!");
    }

    @FXML
    private void handleSave() throws IOException {

        System.out.println("Save action clicked!");
    }

    @FXML
    private void handleSaveAs() throws IOException {
        System.out.println("Save As action clicked!");
    }

    @FXML
    private void handleExit() throws IOException {

        System.out.println("Exit action clicked!");
        //close the window
        System.exit(0);
    }


    @FXML
    private void handleBack() throws IOException {

        System.out.println("Back action clicked!");
    }


};


