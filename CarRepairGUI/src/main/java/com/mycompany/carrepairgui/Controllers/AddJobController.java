/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.carrepairgui.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import com.mycompany.carrepairgui.Controllers.MainMenuController;
import com.mycompany.carrepairgui.Model.Job;
import static java.lang.Double.parseDouble;
import java.util.HashSet;



public class AddJobController{
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
    
    private MainMenuController mainController;
    
    public void setMainController(MainMenuController mainController){
        this.mainController = mainController;
    }
    
    @FXML
    private void addjob(){
        String nameData = name.getText();
        String surnameData = surname.getText();
        String modelData = model.getText();
        String registrationData = registration.getText();
        String mileageData = mileage.getText();
        if(mainController != null){ 
            mainController.addNewJobRecord(nameData, surnameData, modelData, registrationData, mileageData);
        }
        Stage stage = (Stage) name.getScene().getWindow();
        stage.close();
    }
}
