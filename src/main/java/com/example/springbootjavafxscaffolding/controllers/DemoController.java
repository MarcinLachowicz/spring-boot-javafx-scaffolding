package com.example.springbootjavafxscaffolding.controllers;

import com.example.springbootjavafxscaffolding.service.MessageProvider;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoController {

    private final SimpleStringProperty currentMessage = new SimpleStringProperty();

    @FXML
    Label messageLabel;

    @FXML
    Button changeMessageButton;

    @Autowired
    MessageProvider messageProvider;

    @FXML
    void initialize() {
        currentMessage.setValue(messageProvider.getNextMessage());
        messageLabel.textProperty().bind(currentMessage);
        changeMessageButton.setOnAction(event -> currentMessage.setValue(messageProvider.getNextMessage()));
    }
}
