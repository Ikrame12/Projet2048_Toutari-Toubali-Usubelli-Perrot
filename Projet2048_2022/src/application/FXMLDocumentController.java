package application;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import projet2048_2022.Grille;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXMLDocumentController implements Initializable {

    
    /*
     * Variables globales correspondant à des objets définis dans la vue (fichier .fxml)
     * Ces variables sont ajoutées à la main et portent le même nom que les fx:id dans Scene Builder
     */
    @FXML
    private Label score; // value will be injected by the FXMLLoader
    @FXML
    private GridPane Grille;
    @FXML
    private Pane fond; // panneau recouvrant toute la fenêtre

    // variable globale pour initialiser le modèle
    private Grille grilleModele = new Grille();

    // variables globales non définies dans la vue (fichier .fxml)
    private final Pane p = new Pane(); // panneau utilisé pour dessiner une tuile "2"
    private final Label c = new Label("2");
    private int x = 24, y = 191;
    private int objectifx = 24, objectify = 191;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        System.out.println("le contrôleur initialise la vue");
        // utilisation de styles pour la grille et la tuile (voir styles.css)
        p.getStyleClass().add("pane");
        //c.getStyleClass().add("tuile");
        Grille.getStyleClass().add("gridpane");
        //GridPane.setHalignment(c, HPos.CENTER);
        fond.getChildren().add(p);
        //p.getChildren().add(c);

        // on place la tuile en précisant les coordonnées (x,y) du coin supérieur gauche
        p.setLayoutX(x);
        p.setLayoutY(y);
        p.setVisible(true);
        c.setVisible(true);
    }

    /*
     * Méthodes listeners pour gérer les événements (portent les mêmes noms que
     * dans Scene Builder
     */
    @FXML
    private void handleDragAction(MouseEvent event) {
        System.out.println("Glisser/déposer sur la grille avec la souris");
        double x = event.getX();//translation en abscisse
        double y = event.getY();//translation en ordonnée
        if (x > y) {
            for (int i = 0; i < Grille.getChildren().size(); i++) { //pour chaque colonne
                //for (int j = 0; j < grille.getRowConstraints().size(); j++) { //pour chaque ligne
                System.out.println("ok1");
                Grille.getChildren().remove(i);

                /*Node tuile = grille.getChildren().get(i);
                 if (tuile != null) {
                 int rowIndex = GridPane.getRowIndex(tuile);
                 int rowEnd = GridPane.getRowIndex(tuile);
                 }*/
                // }
            }
        } else if (x < y) {
            System.out.println("ok2");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    Pane p = new Pane();
                    p.getStyleClass().add("pane");
                    Grille.add(p, i, j);
                    p.setVisible(true);
                    Grille.getStyleClass().add("gridpane");
                }
            }
        }
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
        System.out.println("Clic de souris sur le bouton menu");
        try {
            score.setText(Integer.toString(Integer.parseInt(score.getText()) + 1));
            } catch (NumberFormatException nfe) {//...
        }
    }

    @FXML
    public void keyPressed(KeyEvent ke) {
        System.out.println("touche appuyée");
        String touche;
        //touche = ke.getText();
        //if (touche.compareTo("q") == 0) { // utilisateur appuie sur "q" pour envoyer la tuile vers la gauche

        //} else if (touche.compareTo("d") == 0) { // utilisateur appuie sur "d" pour envoyer la tuile vers la droite

        //}
    }
}