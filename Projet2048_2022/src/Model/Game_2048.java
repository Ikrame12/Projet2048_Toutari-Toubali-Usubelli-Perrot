/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import Model.Cell;
import Model.Grid;
import Model.Grid3D;
import Model.Parametres;
import java.awt.Color;
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
    Grid[] grille = new Grid[gridSize];
    Grid3D g = new Grid3D(grille);  
    long score;
    long coup_jouer;
    List<Cell> Move_tried; 
    //constructeur
    public Game_2048(Grid[] grille, Grid3D g) {
        this.grille = grille;
        this.g = g;
    }
    @SuppressWarnings(value = "empty-statement")
    public void updateGrid(){
        
        
        
    }
    
    @SuppressWarnings("empty-statement")
    public Grid[] init_Plateau(Grid[] grille) { //méthode qui affiche le plateau du jeu et ajoute une case libre aléatoirement 

        for(Grid grille1 : grille)  {
            
            grille1 = new Grid();// on crée
            boolean b = grille1.newCell(); // on choisit une cass
            int[][] tab1= new int[gridSize][gridSize];//on crée le tableau d'affichage
            for(Cell c : grille1.getCells()) { //parcourir le hashset 
                tab1[c.getY()][c.getX()] = c.getValeur();// récuperer la valeur
            };

            System.out.print(Arrays.deepToString(tab1) +"\t"+"\n");
        }
        return grille;
    } 
           
    public void Start(){ 
            //méthode pour commencer le jeu
            
            System.out.println("|___________Jeu 2048__________|\n");
            System.out.println("You can do it !");
            grille = init_Plateau(grille);
            System.out.println("\n");
            System.out.print("Veuillez choisir votre direction =>"
                    + " - d " + " - g " + " - h " + " - b "+ " - G " + " - D "
                    + ": ");
            Scanner sc = new Scanner(System.in);
            System.out.println("\n");
            String s = sc.nextLine();
            
            grille = init_Plateau(grille);
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
                direction = switch (s) {
                    case "d", "droite" -> 2;
                    case "g", "gauche" -> -2;
                    case "h", "haut" -> 1;
                    case "b", "Bas" -> -1;
                    case "G" -> 5;
                    default -> 2;
                };
                
                grille = init_Plateau(grille);
                for(int i=0; i<grille.length;i++){
                boolean b2;
                    b2 = grille[i].lanceurDeplacerCases(direction);
                }
    }
    }
    
    
            }                
                
                
                
            
            

  
    
     
        
        
       
        
    
                





   
    


    

