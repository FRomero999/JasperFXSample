module com.example.jasperfxsample {
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.swing;
    requires java.sql;
    requires jasperreports;

    opens com.example.jasperfxsample to javafx.fxml;
    exports com.example.jasperfxsample;
}