package models.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class NpcInfoController implements Initializable {
    @FXML
    private Label npcNameLabel;
    @FXML
    private AnchorPane diaryPane,giftsPane,heartEventsPane;


    public void initialize(URL location, ResourceBundle resources) {
        //String url = Controller.npcURLInfo;
    }

    public void goBack(Event ev){ Controller.switchTo("../npcs-screen.fxml", ev); }
}
