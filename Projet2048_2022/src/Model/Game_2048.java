/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import Model.Cell;
import Model.Grid;
import Model.Grid3D;
import Model.Parametres;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Game_2048 implements Parametres { //classe qui va initialser ce qu'il va se passer lors du jeu 
    Grid[] grille ;
    Grid3D g ;  
    long score;
    long coup_jouer;
    List<Cell> Move_tried; 
    
    
    /*public void initJeu (){
        //initialisation des grilles 
        for (Grid grille1 : grille) {
            /*boucle des grilles */
            //grille1 = new Grid();
        //}
 
    /*Display*/
    
    public Game_2048(){ //initialisation de la grille de jeu 3D (tableau contenant les 3 grilles)
    grille = new Grid[gridSize];
    g = new Grid3D(grille);
     
    }   

    @SuppressWarnings(value = "empty-statement")
    public void DisplayPlateau() { //méthode qui affiche le plateau du jeu et ajoute une case libre aléatoirement 

        for(Grid grille1 : grille)  {
            grille1 = new Grid();// on crée
            boolean b = grille1.newCell(); // on choisit une cass
            int[][] tab1= new int[gridSize][gridSize];//on crée le tableau d'affichage
            for(Cell c : grille1.getCells()) { //parcourir le hashset 
                tab1[c.getY()][c.getX()] = c.getValeur();// récuperer la valeur
            };

            System.out.print(Arrays.deepToString(tab1) +"\t"+"\n");
        }
    } 
    
     public  void init_game() { //méthode pour initialiser les différentes cases
        for (Grid grille1 : grille) {
            grille1= new Grid();
            for(int i=0;i< gridSize;i++) {
                for(int j=0;j<gridSize;j++){
                Cell C = new Cell(i,j,0);    
                }
                 
            }
        }
        score = 0;
        coup_jouer = 0;
        DisplayPlateau();
        
      }
                    
    public void Start(){ //méthode pour commencer le jeu
            System.out.println("|___________Jeu 2048__________|\n");
            
            this.init_game();
            System.out.println("\n");
            System.out.print("Veuillez choisir votre direction =>"
                    + " - d " + " - g " + " - h " + " - b "+ " - G " + " - D "
                    + ": ");
            Scanner sc = new Scanner(System.in);
            System.out.println("\n");
            String s = sc.nextLine();
            
           
            if (!(s.equals("d") 
                    || s.equals("g") 
                    || s.equals("h") 
                    || s.equals("b")
                    ||s.equals("D")
                    ||s.equals("G"))) {
                
                System.out.println("Vous devez ecrire "
                        + "d pour Droite "
                        + "\n"
                        + "g pour Gauche "
                        + "\n"
                        + "h pour Haut "
                        + "\n"
                        + "b pour Bas "
                        + "\n"
                        + "G pour profondeur a gauche "
                        + "\n"
                        + "D pour pofondeur a droite");
            } else {
                int direction;
                switch (s) {
                    case "d":
                    case "droite":
                        direction = 2;
                        break;
                    case "g":
                    case "gauche":
                        direction = -2;
                        break;
                    case "h":
                    case "haut":
                        direction = 1;
                        break;
                    case "b":
                    case "Bas":
                        direction = -1;
                        break;
                    case "G":
                        direction = 5;
                        break;
                    default:
                        direction = 2;
                        break;
                }
                
            }
        }
    //Autre méthode pour afficher le plateau 
    public String toString() {
        StringJoiner output = new StringJoiner("");
        for(Grid grille1 : grille) {
            grille1 = new Grid();
            int[][] tab1= new int[gridSize][gridSize];
            for(Cell c : grille1.getCells()) {
                tab1[c.getY()][c.getX()] = c.getValeur();
                output.add(String.format("[%3d]",c.getValeur()));
                
            };
            output.add("\n");
            
        }
        return output.toString();  
    }
   
    } 


    

