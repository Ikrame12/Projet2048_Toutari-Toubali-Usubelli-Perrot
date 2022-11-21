/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Game_2048 implements Parametres {
    Grid[] grille = new Grid[gridSize];
    Grid3D g = new Grid3D(grille);  
    
    
    
    /*public void initJeu (){
        //initialisation des grilles 
        for (Grid grille1 : grille) {
            /*boucle des grilles */
            //grille1 = new Grid();
        //}
 
    /*Display*/
    
    @SuppressWarnings("empty-statement")
    public void DisplayPlateau(){
        
        for (Grid grille1 :grille) {
        grille1 = new Grid();   
        int[][] tab1= new int[gridSize][gridSize];
        for(Cell c : grille1.getCells()) {
        tab1[c.getY()][c.getX()] = c.getValeur();
        
        };
        System.out.print(Arrays.deepToString(tab1) +"\t"+"\n");
        }
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


        
}

    

