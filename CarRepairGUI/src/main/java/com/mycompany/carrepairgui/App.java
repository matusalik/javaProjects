package com.mycompany.carrepairgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.mycompany.carrepairgui.Model.JobList;
import com.mycompany.carrepairgui.Controllers.MainMenuController;
public class App extends Application {

    private static Scene scene;
    private static JobList joblist;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MainMenu"), 607, 400);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        fxmlLoader.setControllerFactory(p -> {return new MainMenuController(joblist);});
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        joblist = new JobList();
        
        launch();
    }

}