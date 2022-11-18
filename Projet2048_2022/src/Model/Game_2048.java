/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import static Model.Parametres.gridSize;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Game_2048 implements Parametres {
    
    Grid3D g = new Grid3D();  
    long score;
    long coup_jouer;
    List<Cell> Move_tried;
    
    
    
    /*Display*/
    
    public void DisplayPlateau(){
        int[][] tab1= new int[gridSize][gridSize];
        g.getGrille().getGrille().forEach(c -> {
            tab1[c.getY()][c.getX()] = c.getValeur();
        });
        for (int i = 0; i < 3; i++){  
        System.out.print(Arrays.deepToString(tab1) +"\t"+"\n");
        }
    }
    
    public void Start(){
            System.out.println("Déplacer vers la Droite (d), Gauche (g), Haut (h), ou Bas (b) ?");
            Scanner sc = new Scanner(System.in);
                    String s = sc.nextLine();
            s.toLowerCase();
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
                if (s.equals("d") || s.equals("droite")) {
                    direction = RIGHT;
                } else if (s.equals("g") || s.equals("gauche")) {
                    direction = LEFT;
                } else if (s.equals("h") || s.equals("haut")) {
                    direction = UP;
                } else if (s.equals("b") || s.equals("Bas")) {
                    direction = DOWN;
                } else if (s.equals("G")) {
                    direction = PRO_LEFT;
                } else {
                    direction = PRO_RIGHT;
                }
                
                System.out.println(g);
                
            }
        }
        
}

    

