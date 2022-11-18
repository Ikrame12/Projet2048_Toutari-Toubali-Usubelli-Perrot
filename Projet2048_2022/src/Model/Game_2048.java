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
        g.getGrid().getGrille().forEach(c -> {
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
                boolean b2 = g.lanceurDeplacerCases(direction);
                if (b2) {
                    b = g.nouvelleCase();
                    if (!b) g.gameOver();
                }
                System.out.println(g);
                if (g.getValeurMax()>=OBJECTIF) g.victory();
            }
        }
        g.gameOver();
}
// * Game Related Functions *//
   
    
    
    
    
    
    
     
    
// * Game Related Functions *//
    
public boolean endGame() {
    
        if (g.getGrille1().getGrille().size() < gridSize * gridSize&this.g.getGrille2().getGrille().size() < gridSize * gridSize&this.g.getGrille3().getGrille().size() < gridSize * gridSize) {
            return false;
        } else {
            for (Cell c : g.getGrille1().getGrille()) {
                  for (int i = 1; i <= 2; i++) {
                    if (c.getVoisinDirect(i) != null) {
                        if (c.valeurEgale(c.getVoisinDirect(i))) {
                            return false;
                        }
                    }
                }
            }
        }
             for (Cell c :g.getGrille2().getGrille()) {
                for (int i = 1; i <= 2; i++) {
                    if (c.getVoisinDirect(i) != null) {
                        if (c.valeurEgale(c.getVoisinDirect(i))) {
                            return false;
                        }
                    }
                }
            }
              for (Cell c : g.getGrille3().getGrille()) {
                for (int i = 1; i <= 2; i++) {
                    if (c.getVoisinDirect(i) != null) {
                        if (c.valeurEgale(c.getVoisinDirect(i))) {
                            return false;
                        }
                    }
                }
            }
        
        return true;
    }


         /*____________*/
    public void victory() {
        System.out.println("Bravo ! Vous avez atteint " + this.g.getValeurMax());
        System.exit(0);
    }

    public void gameOver() {
        System.out.println("La partie est finie. Votre score est " + this.g.getValeurMax());
        System.exit(1);
    }
        /*______________*/
}
