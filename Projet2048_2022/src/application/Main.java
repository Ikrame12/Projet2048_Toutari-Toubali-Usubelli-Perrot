package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.application.Platform;
public class Main extends Application {
  
/**
 * Affichage de l'interface FXML
 * Mise en page de l'interface grâce au CSS
 * @param stage
 * @throws Exception 
 */ 
    @Override
     public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Interface.fxml"));
        
        Scene scene = new Scene(root);
        boolean add = scene.getStylesheets().add("css/styles.css");
        
        stage.setScene(scene);
        stage.show();
        Button btn = new Button();
        btn.setText("Quit");
        btn.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
     }
        
    

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        launch(args);
    }

    }
    


 
    
    



   



   



