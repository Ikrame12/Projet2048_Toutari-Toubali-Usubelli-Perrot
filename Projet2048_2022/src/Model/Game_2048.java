/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

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
    public void DisplayPlateau() { //méthode pour afficher la grille 3D
        for(Grid grille1 : grille)  {
            grille1 = new Grid();
            int[][] tab1= new int[gridSize][gridSize];
            for(Cell c : grille1.getCells()) {
                tab1[c.getY()][c.getX()] = c.getValeur();
                
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
                    
   private boolean addCell(int nbtuiles) {
        for (int i = 0; i < nbtuiles; i++) {
            // Liste de possibiliter
            List<Cell> possibiliter = new ArrayList<Cell>();
            Cell OnePosition;
            // Ajout de toutes les tuile vide dans la liste
            for(Grid grille1 : grille){
                for(Cell C : grille1.Cells){
                  if(C.getValeur()==0) {
                   OnePosition = new Cell(C.x, C.y,0); 
                   possibiliter.add(OnePosition);
                  } 
                }
            }
            // ? Si il n'y a pas de possibliter fin du jeu ?
            if (possibiliter.size() == 0)
                return false;
            Random rand = new Random();
            int newvalue = rand.nextInt(4) >= 2 ? 2 : 4;
            OnePosition = possibiliter.get(rand.nextInt(possibiliter.size()));
            OnePosition.setValeur(newvalue);
        }
        return true;
    }
    public void Start(){ //méthode pour commencer le jeu
        
            System.out.print("Veuillez choisir votre direction:"
                    + " - d " + " - g " + " - h " + " - b "+ " - G " + " - D ");
            Scanner sc = new Scanner(System.in);
            
                    String s = sc.nextLine();
            if (!(s.equals("d") || s.equals("droite")
                    || s.equals("g") || s.equals("gauche")
                    || s.equals("h") || s.equals("haut")
                    || s.equals("b") || s.equals("bas"))) {
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
                        + ""
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

    public String toString() {
        StringJoiner output = new StringJoiner("");
        /*for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                
                Cell EnCours = new Cell(i, j,v);
                output.add(String.format("[%3d]", EnCours.getValeur()));
            }
            output.add("\n");
        }*/
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

    

