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
public class Launch implements Parametres { //classe qui va lancer le jeu avec les différentes méthodes du package

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // TODO code application logic here
       Game_2048 jeu = new Game_2048();
       jeu.init_game();
       jeu.Start();
       
    }
    
}
