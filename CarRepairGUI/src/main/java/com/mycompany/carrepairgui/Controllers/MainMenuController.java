package com.mycompany.carrepairgui.Controllers;

import com.mycompany.carrepairgui.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import com.mycompany.carrepairgui.Controllers.AddJobController;
import com.mycompany.carrepairgui.Model.JobList;
import com.mycompany.carrepairgui.Model.Job;
import com.mycompany.carrepairgui.Model.Owner;
import com.mycompany.carrepairgui.Model.Car;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.*;
import javafx.util.converter.DoubleStringConverter;
/**
 * FXML Controller class
 *
 * @author SuperStudent-PL
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
    
    public MainMenuController(JobList sentJobList){
        this.jobList = sentJobList;
        data = FXCollections.observableArrayList(sentJobList.getJobList());
        data.addListener((ListChangeListener.Change<? extends Job> change) -> {
            while(change.next()){
                if(change.wasPermutated()){
                    for(int i = change.getFrom(); i < change.getTo(); i++){
                        System.out.println("change");
                    }
                }
                else if(change.wasUpdated()){
                    System.out.println("update");
                }
                else{
                    for(var remitem : change.getRemoved()){
                        sentJobList.getJobList().remove(remitem);
                    }
                    for(var additem : change.getAddedSubList()){
                        sentJobList.getJobList().add(additem);
                    }
                }
            }
        });
    }  
    
    public void initialize(){
        mainMenu_Table.setItems(data);
        mainMenu_Table.setEditable(true);
        
        Table_Name.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getOwner().getName()));
        Table_Surname.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getOwner().getSurname()));
        Table_Model.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCar().getModel()));
        Table_Registration.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCar().getRegistration()));
        Table_Mileage.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCar().getMileage()));     
    }
    
    @FXML
    private void AddJobButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("AddJob.fxml"));
        Parent root = loader.load();
        AddJobController addJobController = loader.getController();
        addJobController.setMainController(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 400, 400));
        stage.showAndWait();
    }

    @FXML
    private void DelJobButton(ActionEvent event) {
        Job selectedJob = (Job) mainMenu_Table.getSelectionModel().getSelectedItem();
        if(selectedJob != null){
            data.remove(selectedJob);
        }
        else{
            showErrorWindow("No job selected!");
        }
    }
    
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
    
    public void showErrorWindow(String errorMessage){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR!");
        alert.setHeaderText("An error has accured");
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
}
