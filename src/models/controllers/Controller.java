package models.controllers;

import java.io.IOException;
import java.util.HashMap;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.NPCScrapper;
import javafx.scene.Node;

public class Controller {
    public static NPCScrapper npcScrapper;
    public static HashMap<String,String> npcInfo;


    public Controller(){
        npcScrapper = new NPCScrapper();
        npcInfo = new HashMap<>();
    }


    public static void switchTo(String url, Event event){
        try {
            Parent root = FXMLLoader.load(Controller.class.getResource(url));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ioe){ ioe.printStackTrace();}
    }

    public static void switchTo(String url, Stage stage){
        try {
            Parent root = FXMLLoader.load(Controller.class.getResource(url));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ioe){ ioe.printStackTrace();}
    }
}
