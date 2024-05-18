module org.example.mid_sda_q1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.mid_sda_q1 to javafx.fxml;
    exports org.example.mid_sda_q1;
}