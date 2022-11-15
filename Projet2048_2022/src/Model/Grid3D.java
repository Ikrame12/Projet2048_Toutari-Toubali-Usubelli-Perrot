/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ikrame
 */
public class Grid3D implements Parametres {
    
    
    private final HashSet<Cell> grille1;
    private final HashSet<Cell> grille2;
    private final HashSet<Cell> grille3;
    
    
    private int valeurMax = 0;
    private boolean deplacement;
    

    public Grid3D() {
        this.grille1 = new HashSet<>();
        this.grille2 = new HashSet<>();
        this.grille3 = new HashSet<>();
    }

 
    public String toString() {
        int[][] tab1= new int[TAILLE][TAILLE];
        for (Cell c : this.grille1) {
            tab1[c.getY()][c.getX()] = c.getValeur();
        }
        String grid1 = "";
        
        for (int i = 0; i < tab1.length; i++) {
            grid1 += Arrays.toString(tab1[i])
                    ;
        }
        int[][] tab2 = new int[TAILLE][TAILLE];
        for (Cell c : this.grille2) {
            tab2[c.getY()][c.getX()] = c.getValeur();
        }
        String grid2 = "";
        
        for (int i = 0; i < tab2.length; i++) {
            grid1 += Arrays.toString(tab2[i])
                    ;
        }
        int[][] tab3 = new int[TAILLE][TAILLE];
        for (Cell c : this.grille3) {
            tab3[c.getY()][c.getX()] = c.getValeur();
        }
        String grid3 = "";
        
        for (int i = 0; i < tab3.length; i++) {
            grid1 += Arrays.toString(tab3[i])
                    ;
        }
        return grid1 + grid2 +grid3;
    }
    

    public HashSet<Cell> getGrille() {
           System.out.println("Vous voulez quel grille?(1-2-3)");
           Scanner r = new Scanner(System.in);
           //choix de grille
           int g =r.nextInt();
           if(g==1){
               return grille1 ;
           }
           else if(g==2){
               return grille2 ;
           }
           else if(g==2){
               return grille3;
           }
        return null;
           
    }

    public int getValeurMax() {
        return valeurMax;
    }
    

    public boolean partieFinie() {
        if (this.grille1.size() < TAILLE * TAILLE&this.grille2.size() < TAILLE * TAILLE&this.grille3.size() < TAILLE * TAILLE) {
            return false;
        } else {
            for (Cell c : this.grille1) {
                for (int i = 1; i <= 2; i++) {
                    if (c.getVoisinDirect(i) != null) {
                        if (c.valeurEgale(c.getVoisinDirect(i))) {
                            return false;
                        }
                    }
                }
            }
             for (Cell c : this.grille2) {
                for (int i = 1; i <= 2; i++) {
                    if (c.getVoisinDirect(i) != null) {
                        if (c.valeurEgale(c.getVoisinDirect(i))) {
                            return false;
                        }
                    }
                }
            }
              for (Cell c : this.grille3) {
                for (int i = 1; i <= 2; i++) {
                    if (c.getVoisinDirect(i) != null) {
                        if (c.valeurEgale(c.getVoisinDirect(i))) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean lanceurDeplacerCases(int direction) {
        Cell[] extremites = this.getCasesExtremites(direction);
        deplacement = false; // pour vérifier si on a bougé au moins une case après le déplacement, avant d'en rajouter une nouvelle
        for (int i = 0; i < TAILLE; i++) {
            switch (direction) {
                case HAUT:
                    this.deplacerCasesRecursif(extremites, i, direction, 0);
                    break;
                case BAS:
                    this.deplacerCasesRecursif(extremites, i, direction, 0);
                    break;
                case GAUCHE:
                    this.deplacerCasesRecursif(extremites, i, direction, 0);
                    break;
                default:
                    this.deplacerCasesRecursif(extremites, i, direction, 0);
                    break;
            }
        }
        return deplacement;
    }

    private void fusion(Cell c) {
        c.setValeur(c.getValeur() * 2);
        if (this.valeurMax < c.getValeur()) {
            this.valeurMax = c.getValeur();
        }
        deplacement = true;
    }

    private void deplacerCasesRecursif(Cell[] extremites, int rangee, int direction, int compteur) {
        if (extremites[rangee] != null) {
            if ((direction == HAUT && extremites[rangee].getY() != compteur)
                    || (direction == BAS && extremites[rangee].getY() != TAILLE - 1 - compteur)
                    || (direction == GAUCHE && extremites[rangee].getX() != compteur)
                    || (direction == DROITE && extremites[rangee].getX() != TAILLE - 1 - compteur)) {
                this.grille1.remove(extremites[rangee]);
                switch (direction) {
                    case HAUT:
                        extremites[rangee].setY(compteur);
                        break;
                    case BAS:
                        extremites[rangee].setY(TAILLE - 1 - compteur);
                        break;
                    case GAUCHE:
                        extremites[rangee].setX(compteur);
                        break;
                    default:
                        extremites[rangee].setX(TAILLE - 1 - compteur);
                        break;
                }
                this.grille1.add(extremites[rangee]);
                deplacement = true;
            }
            Cell voisin = extremites[rangee].getVoisinDirect(-direction);
            if (voisin != null) {
                if (extremites[rangee].valeurEgale(voisin)) {
                    this.fusion(extremites[rangee]);
                    extremites[rangee] = voisin.getVoisinDirect(-direction);
                    this.grille1.remove(voisin);
                    this.deplacerCasesRecursif(extremites, rangee, direction, compteur + 1);
                } else {
                    extremites[rangee] = voisin;
                    this.deplacerCasesRecursif(extremites, rangee, direction, compteur + 1);
                }
            }
        }
    }

    /*
    * Si direction = HAUT : retourne les 4 cases qui sont le plus en haut (une pour chaque colonne)
    * Si direction = DROITE : retourne les 4 cases qui sont le plus à droite (une pour chaque ligne)
    * Si direction = BAS : retourne les 4 cases qui sont le plus en bas (une pour chaque colonne)
    * Si direction = GAUCHE : retourne les 4 cases qui sont le plus à gauche (une pour chaque ligne)
    * Attention : le tableau retourné peut contenir des null si les lignes/colonnes sont vides
     */
    public Cell[] getCasesExtremites(int direction) {
        Cell[] result = new Cell[TAILLE];
        for (Cell c : this.grille1) {
            switch (direction) {
                case HAUT:
                    if ((result[c.getX()] == null) || (result[c.getX()].getY() > c.getY())) { // si on n'avait pas encore de case pour cette rangée ou si on a trouvé un meilleur candidat
                        result[c.getX()] = c;
                    }
                    break;
                case BAS:
                    if ((result[c.getX()] == null) || (result[c.getX()].getY() < c.getY())) {
                        result[c.getX()] = c;
                    }
                    break;
                case GAUCHE:
                    if ((result[c.getY()] == null) || (result[c.getY()].getX() > c.getX())) {
                        result[c.getY()] = c;
                    }
                    break;
                default:
                    if ((result[c.getY()] == null) || (result[c.getY()].getX() < c.getX())) {
                        result[c.getY()] = c;
                    }
                    break;
            }
        }
        return result;
    }

    public void victory() {
        System.out.println("Bravo ! Vous avez atteint " + this.valeurMax);
        System.exit(0);
    }

    public void gameOver() {
        System.out.println("La partie est finie. Votre score est " + this.valeurMax);
        System.exit(1);
    }

    public boolean nouvelleCase() {
        if (this.grille1.size() < TAILLE * TAILLE) {
            ArrayList<Cell> casesLibres = new ArrayList<>();
            Random ra = new Random();
            int valeur = (1 + ra.nextInt(2)) * 2;
            // on crée toutes les cases encore libres
            for (int x = 0; x < TAILLE; x++) {
                for (int y = 0; y < TAILLE; y++) {
                    Cell c = new Cell(x, y, valeur);
                    if (!this.grille1.contains(c)) { // contains utilise la méthode equals dans tuile
                        casesLibres.add(c);
                    }
                }
            }
            // on en choisit une au hasard et on l'ajoute à la grille
            Cell ajout = casesLibres.get(ra.nextInt(casesLibres.size()));
            ajout.setGrille(this);
            System.out.println(ajout);
            this.grille1.add(ajout);
            if ((this.grille1.size() == 1) || (this.valeurMax == 2 && ajout.getValeur() == 4)) { // Mise à jour de la valeur maximale présente dans la grille si c'est la première case ajoutée ou si on ajoute un 4 et que l'ancien max était 2
                this.valeurMax = ajout.getValeur();
            }
            return true;
        } else {
            return false;
        }
    }  
}
