package com.example.jasperfxsample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.sf.jasperreports.engine.JRException;

import java.sql.SQLException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        welcomeText.setText("Welcome to JavaFX Application!");
        try {
            (new ReportService()).generateReport();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}