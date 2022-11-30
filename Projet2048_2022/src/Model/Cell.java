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
    
        int x;
        int y;    
 private int valeur;
 private Grid grille;// on déclare une grille de type Grid3D en privée

 //Constructeur de la classe "Cell"
 
 /**
  * 
  * @param abs correspond a l'abcisse de la case
  * @param ord correspond a l'odonnee de la case 
  * @param v   correspond a la valeur dans la case
  */
 
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
public Cell getVoisinDirect(int direction) {
        if (direction == UP) {
            for (int i = this.y - 1; i >= 0; i--) {
                for (Cell c : grille.getCells()) {
                    if (c.getX() == this.x && c.getY() == i) {
                        return c;
                    }
                }
            }
        } else if (direction == DOWN) {
            for (int i = this.y + 1; i < gridSize; i++) {
                for (Cell c : grille.getCells()) {
                    if (c.getX() == this.x && c.getY() == i) {
                        return c;
                    }
                }
            }
        } else if (direction == LEFT) {
            for (int i = this.x - 1; i >= 0; i--) {
                for (Cell c : grille.getCells()) {
                    if (c.getX() == i && c.getY() == this.y) {
                        return c;
                    }
                }
            }
        } else if (direction == LEFT) {
            for (int i = this.x + 1; i < gridSize; i++) {
                for (Cell c : grille.getCells()) {
                    if (c.getX() == i && c.getY() == this.y) {
                        return c;
                    }
                }
            }
        }
        return null;
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
        return "Case(" + this.x + "," + this.y + "," + this.valeur + ")";
    }

}


