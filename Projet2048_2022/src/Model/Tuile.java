/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ikram
 */

    public class Tuile implements Parametres { 
 private int x, y, valeur;    
 private Grille grille;// on déclare une grille de type Grille en privée

 //Constructeur de la classe "Case"
 public Tuile(int abs, int ord, int v){
 this.x=abs;
 this.y=ord;
 this.valeur=v;
 }
 
 //Création des setters et des getters
 public void setGrille(Grille g){
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
    if(obj instanceof Tuile){
    Tuile c= (Tuile) obj;
    return (this.x==c.x && this.y==c.y);
    }
    else{
        return false;
    }
}

//commentaires 
public int hashCode(){
return this.x*7 + this.y*13;

}
 
//commentaires 
 public boolean valeurEgale(Tuile c){
 if (c != null){
 return this.valeur ==c.valeur;
 }else {
 return false;
 }
 }
 
 //comentaires
 public Tuile getVoisinDirect(int direction){
     if (direction == HAUT){
     for(int i = this.y -1 ; i>=0; i--){
       for (Tuile c : grille.getGrille()) {
                    if (c.getX() == this.x && c.getY() == i){ 
     return c;
     }
     }    
     }
     }
     else if (direction == BAS){
             for(int i= this.y +1; i<TAILLE; i++){
             for (Tuile c : grille.getGrille()){
             if(c.getX()== this.x && c.getY() == i){
             return c;
             }
             }
             }
             }
     else if (direction == GAUCHE){
     for(int i = this.x -1; i>=0; i--){
     for (Tuile c : grille.getGrille()){
     if (c.getX()==i && c.getY()== this.y){
     return c;
     }
     }
     }
     }
     else if (direction == DROITE){
     for (int i = this.x +1 ; i<TAILLE; i++){
     for (Tuile c : grille.getGrille()){
     if (c.getX()== i && c.getY() == this.y){
     return c;
             }
     }
     }
     }
 
 return null;
 }
 
 
 
 // Redéfinition de la méthode String
 @Override
 public String toString(){
 return "Case("+this.x + "," +this.y +"," + this.valeur + ")";
 }
 
}


