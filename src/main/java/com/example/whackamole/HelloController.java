package com.example.whackamole;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button btnHello;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) throws Exception
    {

        welcomeText.setText("Welcome to JavaFX Application!");
        btnHello.setText("Done");
        ChangeScene.changeScene(event, "whackboard.fxml");
    }
}