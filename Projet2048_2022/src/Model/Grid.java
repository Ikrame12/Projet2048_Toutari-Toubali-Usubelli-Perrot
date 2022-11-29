/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */

/**
 * Représente une grille
 * 
 */
public class Grid implements Parametres{
    final HashSet<Cell> Cells = new HashSet<>();
    private int valeurMax = 0;
    boolean deplacement = false ;
 
    
    /**
     * Constructeur d'une grille
     */
    public void Grid() {
          setCells(Cells);
          deplacement = false ;
    }
    
    
    /**
     * Setter
     * Permet de demander un changement d'état du paramètre "Cells"
     * @param Cells plusieurs cases 
     */
    public void setCells(HashSet<Cell> Cells){
        for(int i=0;i< gridSize;i++) {
                for(int j=0;j<gridSize;j++){
                Cell C = new Cell(i,j,0);
                this.Cells.add(C);    
                }
        var ra = new Random();
            int x = ra.nextInt(4);
            int y = ra.nextInt(4);
        for (Cell c : this.Cells){
            if(x==c.getX()||y==c.getY())  {
                c.setValeur(2);
            }
        }
    }
    }
    /*  Getters  */
    /**
     * Getter 
     * Permet l'accès en lecture à la valeur Cells
     * @return 
     */
    public HashSet<Cell> getCells() {
        return Cells;
    }
/**
 * Getter
  * Permet l'accès en lecture à la valeur valeurMax 
  * @return retourne la valeur "valeurMax"
  */
    public int getValeurMax() {
        return valeurMax;
    }

/**
 * Getter
 * Permet l'accès en lecture à la valeur "LOG"
 * @return retourne LOG
 */
    public static Logger getLOG() {
        return LOG;
    }
    /* Logger */
    private static final Logger LOG = Logger.getLogger(Grid.class.getName());
    
    /* Setters */
    /**
     * Permet de demander un changement d'état du paramètre "valeurMax"
     * @param valeurMax 
     */
    public void setValeurMax(int valeurMax) {
        this.valeurMax = valeurMax;
    }

 
    //Méthodes des mouvements 
    
    /**
     * Fusionne 2 cases
     * (Utile pour les mouvements)
     * @param c correspond à une case
     */
    private void fusion(Cell c) {
     c.setValeur(c.getValeur() * 2);
     if (this.valeurMax < c.getValeur()) {
     this.valeurMax = c.getValeur();
        }
    }
    
    /**
     * Détermine les extrémités d'une grille
     * @param direction correspond à la direction choisie
     * @return les extrémités d'une grille
     */
    public Cell[] getCellBorders(int direction) {
        Cell[] result = new Cell[gridSize];
        for (Cell c : this.Cells) {
            switch (direction) {
                case UP -> {
                    if ((result[c.getX()] == null) || (result[c.getX()].getY() > c.getY())) { // si on n'avait pas encore de case pour cette rangée ou si on a trouvé un meilleur candidat
                        result[c.getX()] = c;
                    }
                }
                case DOWN -> {
                    if ((result[c.getX()] == null) || (result[c.getX()].getY() < c.getY())) {
                        result[c.getX()] = c;
                    }
                }
                
                case LEFT -> { 
                    if ((result[c.getY()] == null) || (result[c.getY()].getX() > c.getX())) {
                        result[c.getY()] = c;
                    }
                }
                default -> {
                    if ((result[c.getY()] == null) || (result[c.getY()].getX() < c.getX())) {
                        result[c.getY()] = c;
                    }
                   
                } 
            }
        }
        return result;
    }
    
    /**
     * Création d'une nouvelle case 
     * @return vrai si la valeur max est dans la case 
     */
     public boolean newCell() {
        //on ajoute un nombre aléatoire si y a des cases libres 
        if (this.getCells().size() < gridSize * gridSize) {
            ArrayList<Cell> casesLibres = new ArrayList<>();
            Random ra = new Random();
            int valeur = (1 + ra.nextInt(2)) * 2; //les nombres générés sont soit 0 soit 1 et il nous donne alors 2 ou 4 après l'ajout de 1 et la multiplication par 2
            // on crée toutes les cases encore libres
            for (int x = 0; x < gridSize; x++) {
                for (int y = 0; y < gridSize; y++) {
                    Cell c = new Cell(x, y, valeur);
                    if (!this.getCells().contains(c)) { // contains utilise la méthode equals 
                        casesLibres.add(c);
                    }
                }
            }
            // on en choisit une au hasard et on l'ajoute à la grille
            Cell ajout = casesLibres.get(ra.nextInt(casesLibres.size()));
            ajout.setG(this);
            //System.out.println(ajout);
            this.getCells().add(ajout);
            if ((this.getCells().size() == 1) || (this.valeurMax == 2 && ajout.getValeur() == 4)) { // Mise à jour de la valeur maximale présente dans la grille si c'est la première case ajoutée ou si on ajoute un 4 et que l'ancien max était 2
                this.valeurMax = ajout.getValeur();
            }
            return true;
        } else {
            return false;
        }
    }
     
     
     /**
      * Affichage des grilles 
      * @return les grilles
      */
    
     @Override
    public String toString() {
        int[][] tableau = new int[gridSize][gridSize];
        this.Cells.forEach(c -> {
            tableau[c.getY()][c.getX()] = c.getValeur();
        });
        String result = "";
        for (int[] tableau1 : tableau) {
            result += Arrays.toString(tableau1) + "\n";
        }
        return result;
    }
    
}
