/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ikrame
 */
public class Grid3D implements Parametres {
    
    
    private  Grid grille1;
    private Grid grille2;
    private Grid grille3;
    
    
    private int valeurMax = 0;
    private boolean deplacement;

    public Grid getGrille1() {
        return grille1;
    }

    public Grid getGrille2() {
        return grille2;
    }

    public Grid getGrille3() {
        return grille3;
    }

    public boolean isDeplacement() {
        return deplacement;
    }
    

   

    //demander quel grille
    public Grid getGrille() {
           System.out.println("Vous voulez quel grille?(1-2-3)");
           Scanner r = new Scanner(System.in);
           //choix de grille
           int g =r.nextInt();
           if(g==1){
               return grille1 ;
           }
           else if(g==2){
               return grille2 ;
           }
           else if(g==2){
               return grille3;
           }
        return null;
           
    }

    public int getValeurMax() {
        return valeurMax;
    }
    }

    

 

   

