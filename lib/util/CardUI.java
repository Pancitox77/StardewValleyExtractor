package util;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import models.controllers.Controller;

public class CardUI extends VBox {
    public CardUI(String name, String urlButton, String npcInfoUrl){
        //VBox Style
        setAlignment(Pos.CENTER);
        setOnMouseEntered(ev -> setCursor(Cursor.HAND));
        setOnMouseExited(ev -> setCursor(Cursor.DEFAULT));
        setBorder(new Border(
            new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)
        ));
        setOnMouseClicked(ev -> {
            Controller.npcInfo = Controller.npcScrapper.getNpcInfo(npcInfoUrl);
            Controller.switchTo(urlButton, ev);
        });
        

        //Name Label Style
        Label nameLabel = new Label(name);
        nameLabel.setFont(Font.font("System", FontWeight.SEMI_BOLD, 20));


        //Button Style
        ImageView imageView = new ImageView(
            new Image(getClass().getResourceAsStream("./npcImages/"+name+".png"))
        );
        imageView.setFitWidth(128);
        imageView.setFitHeight(128);


        getChildren().addAll(nameLabel,imageView);
    }
}
