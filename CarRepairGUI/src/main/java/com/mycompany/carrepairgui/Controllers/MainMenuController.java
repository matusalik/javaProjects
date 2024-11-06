package com.mycompany.carrepairgui.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.io.IOException;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Tooltip;
import javafx.stage.*;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

import com.mycompany.carrepairgui.App;
import com.mycompany.carrepairgui.Controllers.AddJobController;
import com.mycompany.carrepairgui.Model.JobList;
import com.mycompany.carrepairgui.Model.Job;
import com.mycompany.carrepairgui.Model.Client;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for Main Menu view
 * @author mateu
 */
public class MainMenuController{

    private JobList jobList;
    private ObservableList<Job> data;
    @FXML
    private TableView mainMenu_Table;
    @FXML
    private TableColumn<Job, String> Table_Name;
    @FXML
    private TableColumn<Job, String> Table_Surname;
    @FXML
    private TableColumn<Job, String> Table_Model;
    @FXML
    private TableColumn<Job, String> Table_Registration;
    @FXML
    private TableColumn<Job, Double> Table_Mileage;
    @FXML
    private Button AddJobButton;
    @FXML
    private Button DelJobButton;
    @FXML
    private Button RaportButton;
    
    /**
     * Constructor made to pass original jobList to the Controller
     * @param sentJobList 
     */
    public MainMenuController(JobList sentJobList){
        this.jobList = sentJobList;
        data = FXCollections.observableArrayList(sentJobList.getJobList());
    }  
    
    /**
     * Intializes everything that needs to be initialized
     * Tooltips, Table, Table cells, Hotkeys
     */
    public void initialize(){
        var AddJobTooltip = new Tooltip("Let's you add new job to the table");
        AddJobTooltip.setStyle("-fx-font: normal bold 14 Langdon; -fx-base: #AE3522; -fx-text-fill: orange;");
        AddJobButton.setTooltip(AddJobTooltip);
        
        var DelJobTooltip = new Tooltip("Let's you delete a job from the table");
        DelJobTooltip.setStyle("-fx-font: normal bold 14 Langdon; -fx-base: #AE3522; -fx-text-fill: orange;");
        DelJobButton.setTooltip(DelJobTooltip);                       
        
        mainMenu_Table.setItems(data);
        mainMenu_Table.setEditable(true);
        
        Table_Name.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getOwner().getName()));
        Table_Surname.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getOwner().getSurname()));
        Table_Model.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCar().getModel()));
        Table_Registration.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCar().getRegistration()));
        Table_Mileage.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCar().getMileage()));     
        
        Platform.runLater(this::initializeHotkeys);
    }
    
    /**
     * Initializes hotkeys
     */
    private void initializeHotkeys(){
        Scene addScene = AddJobButton.getScene();
        Scene delScene = DelJobButton.getScene();
        if(addScene != null){
            addScene.getAccelerators().put(
                new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN),
                () -> {
                try {
                    handleAddJobButton();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            );
        }
        if(delScene != null){
            delScene.getAccelerators().put(
                new KeyCodeCombination(KeyCode.DELETE),
                () -> handleDelJobButton()
            );
        }
    }
    
    /**
     * AddJobButton event handler
     * @throws IOException 
     */
    @FXML
    private void handleAddJobButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("AddJob.fxml"));
        Parent root = loader.load();
        AddJobController addJobController = loader.getController();
        addJobController.setMainController(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 400, 400));
        stage.showAndWait();
    }

    /**
     * DelJobButton event handler
     */
    @FXML
    private void handleDelJobButton() {
        Job selectedJob = (Job) mainMenu_Table.getSelectionModel().getSelectedItem();
        if(selectedJob != null){
            data.remove(selectedJob);
        }
        else{
            showErrorWindow("No job selected!");
        }
    }
    
    @FXML
    private void handleRaportButton() {
        List<Client>clientList = new ArrayList<Client>();
        for(Job i : this.data){
            Client client = new Client(i.getOwner().getName(), i.getOwner().getSurname());
            clientList.add(client);
        }
        showRaportWindow(clientList);
    }
    
    /**
     * Adds new job record to a table
     * @param name
     * @param surname
     * @param model
     * @param registration
     * @param mileage 
     */
    public void addNewJobRecord(String name, String surname, String model, String registration, String mileage){
        try{
            if(name.isEmpty() || surname.isEmpty() || model.isEmpty() || registration.isEmpty()){
                showErrorWindow("Please fill all blank spaces!");
            }
            else{
                data.add(new Job(name, surname, model, registration, Double.parseDouble(mileage)));
            }
        }
        catch(Exception ex){
            showErrorWindow("Enter proper mileage value (number)");
        }
    }
    /**
     * Handler for an error message window
     * @param errorMessage 
     */
    public void showErrorWindow(String errorMessage){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR!");
        alert.setHeaderText("An error has accured");
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
    
    public void showRaportWindow(List<Client>Clients){
        Alert alert  = new Alert(AlertType.INFORMATION);
        alert.setWidth(300);
        alert.setHeight(300);
        alert.setTitle("RAPORT");
        alert.setHeaderText("List of yout clients");
        String temp = "";
        for(Client i : Clients){
            temp = temp + i.name() + " " + i.surname() + "\n";
        }
        alert.setContentText(temp);
        alert.showAndWait();
    }
}
