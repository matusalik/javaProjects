/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.carrepairgui.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;

import com.mycompany.carrepairgui.Controllers.MainMenuController;

/**
 * Controller for a popup window called from MainMenu controller It is used by
 * user to add new job to the table
 *
 * @author mateu
 */
public class AddJobController {

    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField model;
    @FXML
    private TextField registration;
    @FXML
    private TextField mileage;
    @FXML
    private Button AddJobButton;

    private MainMenuController mainController;

    /**
     * Initializes everything that needs to be initialized Here calls only
     * hotkey initializator
     */
    public void initialize() {
        Platform.runLater(this::initializeHotkeys);
    }

    /**
     * Set's it's main controller (main menu controller) as it is called from
     * there
     *
     * @param mainController
     */
    public void setMainController(MainMenuController mainController) {
        this.mainController = mainController;
    }

    /**
     * Initializes hotkeys
     */
    private void initializeHotkeys() {
        Scene addScene = AddJobButton.getScene();
        addScene.getAccelerators().put(
                new KeyCodeCombination(KeyCode.ENTER),
                () -> handleAddJobButton()
        );
    }

    /**
     * AddJobButton event handler
     */
    @FXML
    private void handleAddJobButton() {
        String nameData = name.getText();
        String surnameData = surname.getText();
        String modelData = model.getText();
        String registrationData = registration.getText();
        String mileageData = mileage.getText();
        if (mainController != null) {
            mainController.addNewJobRecord(nameData, surnameData, modelData, registrationData, mileageData);
        }
        Stage stage = (Stage) name.getScene().getWindow();
        stage.close();
    }
}
