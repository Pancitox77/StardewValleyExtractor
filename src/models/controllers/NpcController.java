package models.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import util.CardUI;
import util.NPCScrapper;

public class NpcController implements Initializable {
    @FXML
    private GridPane gridPane;    

    public void initialize(URL url, ResourceBundle resources) {
        ArrayList<CardUI> cards = new ArrayList<>();
        
        //Create a Card (GUI Element) for each npc
        for(HashMap<String,String> npc: Controller.npcScrapper.getNPCList()){
            CardUI card = new CardUI(
                npc.get(NPCScrapper.NPC_NAME),
                "../npcinfo-screen.fxml",
                npc.get(NPCScrapper.NPC_LINK)
            );
            cards.add(card);
        }

        //Show cards to user
        int column=0, row=0;
        for(CardUI card: cards){
            if(column >= gridPane.getColumnCount()){ column=0; row++; }

            gridPane.add(card,column,row);
            column++;
        }
    }
}
