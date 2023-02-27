package models.controllers;

import javafx.event.Event;

public class MainController {
    public void npcButtonClicked(Event ev){ Controller.switchTo("../npcs-screen.fxml", ev); }
}
