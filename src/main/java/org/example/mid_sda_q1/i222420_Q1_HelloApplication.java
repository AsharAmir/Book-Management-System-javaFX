package org.example.mid_sda_q1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class i222420_Q1_HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(i222420_Q1_HelloApplication.class.getResource("i222420_Q1_hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 725, 510); //fixed size throughout all frames : w/725 h/510
        //locking scene size
        stage.setResizable(false);
        stage.setTitle("Books Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}