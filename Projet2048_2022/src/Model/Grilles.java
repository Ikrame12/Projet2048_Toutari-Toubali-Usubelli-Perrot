package Model;

import static Model.Parametres.TAILLE;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hp
 */
public class Grilles extends Grille {    
  final Grille tab[]; 
   //on choisit un tableau parceque on un nombre précis d'éléments (3G)
   public Grilles() {//le constructeur de la méthode
        this.tab = new Grille[3];
   
  }
   
// la grille golbale hérite de Grille
    //tableau qui contient le strois grilles ensemble

   

public  void  affich(){
//la méthode d'affichage  
   
   for (int i = 0; i < tab.length; i++){
          System.out.println(tab[i]);
     }
  
  }     
}  
       
     
       
    

