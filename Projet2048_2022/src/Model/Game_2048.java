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
    
    public Game_2048(){
    grille = new Grid[gridSize];
    g = new Grid3D(grille);
     
    }   

    @SuppressWarnings(value = "empty-statement")
    public void DisplayPlateau() {
        for(Grid grille1 : grille)  {
            grille1 = new Grid();
            int[][] tab1= new int[gridSize][gridSize];
            for(Cell c : grille1.getCells()) {
                tab1[c.getY()][c.getX()] = c.getValeur();
                
            };
            System.out.print(Arrays.deepToString(tab1) +"\t"+"\n");
            
        }
    }   
    
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
    public void Start(){
        
             
            Scanner sc = new Scanner(System.in);
                    String s = sc.nextLine();
            if (!(s.equals("d") || s.equals("droite")
                    || s.equals("g") || s.equals("gauche")
                    || s.equals("h") || s.equals("haut")
                    || s.equals("b") || s.equals("bas"))) {
                System.out.println("Vous devez écrire"
                        + "d pour Droite, "
                        + "g pour Gauche, "
                        + "h pour Haut  "
                        + "b pour Bas"
                        + "G pour profondeur à gauche"
                        + "D pour pofondeur à droite");
            } else {
                int direction;
                switch (s) {
                    case "d":
                    case "droite":
                        direction = RIGHT;
                        break;
                    case "g":
                    case "gauche":
                        direction = LEFT;
                        break;
                    case "h":
                    case "haut":
                        direction = UP;
                        break;
                    case "b":
                    case "Bas":
                        direction = DOWN;
                        break;
                    case "G":
                        direction = PRO_LEFT;
                        break;
                    default:
                        direction = PRO_RIGHT;
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

    

