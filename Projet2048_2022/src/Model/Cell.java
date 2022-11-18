/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ikrame
 */

    public class Cell implements Parametres { 
 private int x, y, valeur;    
 private Grid grille;// on déclare une grille de type Grid3D en privée

 //Constructeur de la classe "Cell"
 public Cell(int abs, int ord, int v){
 this.x=abs;
 this.y=ord;
 this.valeur=v;
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

public int hashCode(){
return this.x*7 + this.y*13;
}

 public boolean valeurEgale(Cell c){
 if (c != null){
 return this.valeur ==c.valeur;
 }else {
 return false;
 }
 }
 
 
 
 
 // Redéfinition de la méthode String
 @Override
 public String toString(){
 return "Case("+this.x + "," +this.y +"," + this.valeur + ")";
 }
 
}


