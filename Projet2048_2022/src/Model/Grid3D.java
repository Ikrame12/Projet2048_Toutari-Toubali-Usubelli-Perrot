/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import static Model.Parametres.gridSize;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ikrame
 */
public class Grid3D implements Parametres {
    
    private Grid[] Plateau = new Grid[gridSize];
    
    
    
    private final int valeurMax = 0;

    public Grid3D(Grid[] Plateau) {
        this.Plateau = Plateau ;
    }

   

    
    public void DisplayGrid() {
        for (Grid Plateau1 : Plateau) {
            int[][] tableau = new int[gridSize][gridSize];
            Plateau1.getCells().forEach(c -> {
                tableau[c.getY()][c.getX()] = c.getValeur();
            }); for (int[] tableau1 : tableau) {
                Arrays.toString(tableau1);
            }   System.out.print("\n");
        }
        
    }
    
    

    public Grid[] getPlateau() {
        return Plateau;
    }

    

  
    public void Deplacement_Profondeur(int direction){
        if(direction == PRO_LEFT){
         //récuperer la position en cours
        
        }
        if(direction == PRO_RIGHT){
            
        }
    }
   

    //demander quelle grille
    public Grid getGrille() {
           System.out.println("Vous voulez quel grille?(1-2-3)");
           Scanner r = new Scanner(System.in);
           //choix de grille
           int g =r.nextInt();
           if(g==1){
               return Plateau[1] ;
           }
           else if(g==2){
               return Plateau[2] ;
           }
           else if(g==2){
               return Plateau[3];
           }
        return null;
           
    }
    @Override
    public String toString(){
    //afficher les 3 grilles
                for (Grid Plateau1 : Plateau) {
            System.out.print(Plateau1);
        }
        
        
        
        
        return null; 
    }
    public int getValeurMax() {
        return valeurMax;
    }
    }

    

 

   

