/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


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

/**
 * Initialisation ce qu'il va se passer lors du jeu
 * 
 */
public class Game_2048 implements Parametres {  
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
    
    /**
     * Initialisation de la grille de jeu 3D : tableau contenant les 3 grilles 
     */
    public Game_2048(){ 
    grille = new Grid[gridSize];
    g = new Grid3D(grille);
     
    }   

    /**
     * Affiche le plateau du jeu et ajoute une case libre aléatoirement
     */
    @SuppressWarnings(value = "empty-statement")
    public void DisplayPlateau() {  

        for(Grid grille1 : grille)  {
            grille1 = new Grid();// on crée
            boolean b = grille1.newCell(); // on choisit une case
            int[][] tab1= new int[gridSize][gridSize];//on crée le tableau d'affichage
            for(Cell c : grille1.getCells()) { //on parcourt le hashset 
                tab1[c.getY()][c.getX()] = c.getValeur();// on récupère la valeur
            };

            System.out.print(Arrays.deepToString(tab1) +"\t"+"\n");
        }
    } 
    
    
    /**
     * Méthode pour initialiser les différentes cases 
     */
     public  void init_game() { 
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
      
     /**
      * Méthode pour commencer le jeu 
      */
     
    public void Start(){ 
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
    /**
     * Autre méthode pour afficher le plateau
     * @return ?? 
     */ 
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
    
    /**
     * 
     * @param direction correspond à la direction choisie
     */
    public void turn(int direction){
        
    }
    

    public void fusion_all(){
        
        
    }
        
}

    

