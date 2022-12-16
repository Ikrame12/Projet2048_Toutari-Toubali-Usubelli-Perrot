/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package application;

import Model.Grille3D;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 */
public class FXMLDocumentController implements Initializable {
    private Grille3D grid;
    @FXML
    private GridPane Grille1;
    @FXML
    private GridPane Grille2;
    @FXML
    private GridPane Grille11;
    @FXML
    private Pane fond;
    @FXML
    private Label score;
    private Button Exit = new Button();
    private final Pane p = new Pane(); // panneau utilisé pour dessiner une tuile "2"
    private final Label c = new Label("2");
    private int x = 24, y = 191;
    private int objectifx = 24, objectify = 191;
    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
    Stage stage = (Stage)Exit.getScene().getWindow();
    stage.close();
}
    
    
    public FXMLDocumentController() {
        this.grid = new Grille3D();
    }
/**
 * Initialisation de l'interface 
 * @param url
 * @param rb 
 */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // TODO
        System.out.println("le contrôleur initialise la vue");
        // utilisation de styles pour la grille et la tuile (voir styles.css)
        p.getStyleClass().add("pane"); 
        c.getStyleClass().add("tuile");
        Grille1.getStyleClass().add("gridpane");
        GridPane.setHalignment(c, HPos.CENTER);
        fond.getChildren().add(p);
        p.getChildren().add(c);

        // on place la tuile en précisant les coordonnées (x,y) du coin supérieur gauche
        p.setLayoutX(x);
        p.setLayoutY(y);
        p.setVisible(true);
        c.setVisible(true);
     
    }
}

   
    

