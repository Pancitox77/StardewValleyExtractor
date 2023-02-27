import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.controllers.Controller;

public class App extends Application {
    public static void main(String[] args){ launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("models/main-screen.fxml"));
        Scene scene = new Scene(root);

        new Controller();
        
        stage.setTitle("Stardew Valley Scrapper");
        stage.setScene(scene);
        stage.show();
    }
}
