package application;


import application.Application;
import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author hp
 */
public class Main extends Application {
public void start(Stage stage) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
Scene scene = new Scene(root);
boolean add = scene.getStylesheets().add("css/styles.css");
stage.setScene(scene);
stage.show();
}
public static void main(String[] args) {
launch(args);
}
}

