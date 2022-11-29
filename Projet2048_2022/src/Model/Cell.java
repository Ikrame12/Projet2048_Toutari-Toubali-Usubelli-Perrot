/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.StringJoiner;

/**
 *
 * @author ikrame
 */

/**
 * Initialisation d'une case 
 * 
 */
    public class Cell implements Parametres { 
    
        int x;
        int y;    
    private int valeur;
     private Grid grille;// on déclare une grille de type Grid3D en privée

 
 /**
  * Constructeur de la classe Cell
  * @param abs correspond à l'abcisse de la case
  * @param ord correspond à l'odonnee de la case 
  * @param v   correspond à la valeur dans la case
  */
 
 public Cell(int abs, int ord, int v){
 this.x=abs; //déplacement horizontal
 this.y=ord; //déplacement vertical 
 this.valeur=v; //valeur de la case
 }
 
 //Création des setters et des getters
 
 /**
  * Setter
  * Permet de demander un changement d'état du paramètre "g"
  * @param g grille 
  */
 
 public void setG(Grid g){
 this.grille=g;
 }
 
 /**
  * Setter 
  * Permet de demander un changement d'état du paramètre "x"
  * @param x l'abcisse de la case
  */
 public void setX(int x){
 this.x=x;
 }
 
 /** 
  * Setter
  * Permet de demander un changement d'état du paramètre "y"
  * @param y l'ordonnée de la case
  */
 public void setY(int y){
 this.y=y;
 }
 
 /** 
  * Setter
  * Permet de demander un changement d'état du paramètre "valeur"
  * @param valeur valeur de la case
  */
 public void setValeur(int valeur){
 this.valeur=valeur;
 }
 
 /**
  * Getter
  * Permet l'accès en lecture à la valeur x  
  * @return retourne la valeur x 
  */
 public int getX(){
 return this.x;
 }
 
 /**
  * Getter
  * Permet l'accès en lecture à la valeur y
  * @return retourne la valeur y
  */
 public int getY(){
 return this.y;
 }
 
 /**
  * Getter
  * Permet l'accès en lecture à la valeur "valeur"
  * @return retourne la valeur de valeur
  */
 public int getValeur(){
 return this.valeur;
 }

 /**
  * Vérifie si les cases sont égales
  * @param obj paramètre comparé à la case 
  * @return vrai si les cases (ordonnees et abscisses) sont égales 
  */
     @Override
public boolean equals(Object obj){
    if(obj instanceof Cell){
    Cell c= (Cell) obj;
    return (this.x==c.x && this.y==c.y);
    }
    else{
        return false;
    }
}

    /**
     * Déclaration du hashcode
     *  
     */
    @Override
public int hashCode(){ 
return this.x*7 + this.y*13;
}

/**
 * Indique ce qu'il faut faire si les valeurs de 2 cases sont égales
 * @param c paramètre comparé à la valeur de la case
 * @return vraie si les valeurs sont égales 
 */
 public boolean valeurEgale(Cell c){ 
 if (c != null){
 return this.valeur ==c.valeur;
 }else {
 return false;
 }
 }

 
 
 /**
  * Redéfinition de la méthode String
  * 
  */
public String toString() {
        return "Case(" + this.x + "," + this.y + "," + this.valeur + ")";
    }

}


