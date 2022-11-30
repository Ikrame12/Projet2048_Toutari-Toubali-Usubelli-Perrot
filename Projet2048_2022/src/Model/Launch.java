/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Scanner;

/**
 *
 * @author ikrame
 */
public class Launch implements Parametres {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // TODO code application logic here
        Grid[] grille = new Grid[3];
        Grid3D g = new Grid3D(grille);
        Game_2048 jeu = new Game_2048(grille, g);
        jeu.Start();
        
    }
    
}
