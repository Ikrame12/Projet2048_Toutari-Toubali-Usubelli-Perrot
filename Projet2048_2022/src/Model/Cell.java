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

    public class Cell implements Parametres { 
    
        int x;
        int y;    
    private int valeur;
 private Grid grille;// on déclare une grille de type Grid3D en privée

 //Constructeur de la classe "Cell"
 public Cell(int abs, int ord, int v){
 this.x=abs; //déplacement horizontal
 this.y=ord; //déplacement vertical 
 this.valeur=v; //valeur de la case
 }
 
 //Création des setters et des getters
 public void setG(Grid g){
 this.grille=g;
 }
 
 public void setX(int x){
 this.x=x;
 }
 
 public void setY(int y){
 this.y=y;
 }
 
 public void setValeur(int valeur){
 this.valeur=valeur;
 }
 
 public int getX(){
 return this.x;
 }
 
 public int getY(){
 return this.y;
 }
 
 public int getValeur(){
 return this.valeur;
 }

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
     *
     * @return
     */
    @Override
public int hashCode(){ //déclaration du hashcode
return this.x*7 + this.y*13;
}

 public boolean valeurEgale(Cell c){ //méthode pour indiquer que faire si valeur égale entre 2 cases
 if (c != null){
 return this.valeur ==c.valeur;
 }else {
 return false;
 }
 }

 
 
 
 
 // Redéfinition de la méthode String
    public String toString() {
        StringJoiner output = new StringJoiner("");
        output.add("______________\n");
        output.add("Case :\n");
        output.add(super.toString() + "\n");
        output.add("value : " + valeur);
        return output.toString();
    }
}


