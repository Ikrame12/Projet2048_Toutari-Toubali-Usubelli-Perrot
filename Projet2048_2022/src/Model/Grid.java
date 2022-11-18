/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class Grid implements Parametres{
    //classe qui représente une grille 
    private final HashSet<Cell> grille;
    private int valeurMax = 0;
    private boolean deplacement;

    public Grid() {
        this.grille = new HashSet<>();
    }
    /*  Getters  */
    public HashSet<Cell> getGrille() {
        return grille;
    }

    public int getValeurMax() {
        return valeurMax;
    }

    public boolean isDeplacement() {
        return deplacement;
    }

    public static Logger getLOG() {
        return LOG;
    }
    /* Logger */
    private static final Logger LOG = Logger.getLogger(Grid.class.getName());
    
    /* Setters */
    public void setValeurMax(int valeurMax) {
        this.valeurMax = valeurMax;
    }

    public void setDeplacement(boolean deplacement) {
        this.deplacement = deplacement;
    }
    //Méthodes des mouvements 
    private void fusion(Cell c) {
     c.setValeur(c.getValeur() * 2);
     if (this.valeurMax < c.getValeur()) {
     this.valeurMax = c.getValeur();
        }
    }
    // déterminer les extrémités d'une grille 
    
    public Cell[] getCellBorders(int direction) {
        Cell[] result = new Cell[gridSize];
        for (Cell c : this.grille) {
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
     public boolean newCell() {
        //  on ajoute un nombre aléatoire si y a des cases libres 
        if (this.getGrille().size() < gridSize * gridSize) {
            ArrayList<Cell> casesLibres = new ArrayList<>();
            Random ra = new Random();
            int valeur = (1 + ra.nextInt(2)) * 2;
            // on crée toutes les cases encore libres
            for (int x = 0; x < gridSize; x++) {
                for (int y = 0; y < gridSize; y++) {
                    Cell c = new Cell(x, y, valeur);
                    if (!this.getGrille().contains(c)) { // contains utilise la méthode equals 
                        casesLibres.add(c);
                    }
                }
            }
            // on en choisit une au hasard et on l'ajoute à la grille
            Cell ajout = casesLibres.get(ra.nextInt(casesLibres.size()));
            ajout.setG(this);
            System.out.println(ajout);
            this.getGrille().add(ajout);
            if ((this.getGrille().size() == 1) || (this.valeurMax == 2 && ajout.getValeur() == 4)) { // Mise à jour de la valeur maximale présente dans la grille si c'est la première case ajoutée ou si on ajoute un 4 et que l'ancien max était 2
                this.valeurMax = ajout.getValeur();
            }
            return true;
        } else {
            return false;
        }
    }  
    
}
