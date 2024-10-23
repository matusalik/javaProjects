package com.mycompany.carrepairgui.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
/**
 * FXML Controller class
 *
 * @author SuperStudent-PL
 */
public class MainMenuController implements Initializable {


    @FXML
    private TableView<?> mainMenu_Table;
    @FXML
    private TableColumn<?, ?> Table_Name;
    @FXML
    private TableColumn<?, ?> Table_Model;
    @FXML
    private TableColumn<?, ?> Table_Registration;
    @FXML
    private TableColumn<?, ?> Table_Mileage;
    @FXML
    private Button AddJobButton;
    @FXML
    private Button DelJobButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void AddJobButton(ActionEvent event) {
    }

    @FXML
    private void DelJobButton(ActionEvent event) {
        
    }

}
