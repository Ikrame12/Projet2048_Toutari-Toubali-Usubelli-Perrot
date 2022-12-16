/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Parametres;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import static Model.Parametres.TAILLE;


/**
 * 
 * Initialisation de la grille 3D
 */
public class Grille3D implements Parametres { 

    private Grille[] Plateau;// = new Grille[3];

    private int valeurMax = 0;
    private boolean deplacement;

    
 /**
  * Affichage du plateau 
  */
    public Grille3D() { 
        //System.out.println("jeu2048.l2.Grille3D.<init>() this. "+this.Plateau.toString());
        Grille grille1 = new Grille();
        Grille grille2 = new Grille();
        Grille grille3 = new Grille();
        this.Plateau = new Grille[gridSize];
        this.Plateau[0] = grille1;
        this.Plateau[1] = grille2;
        this.Plateau[2] = grille3;
        //System.out.println("jeu2048.l2.Grille3D.<init>() this. "+this.Plateau[0].toString());
    }

    
    /**
     * Affichage des grilles 
     * @return les grilles 
     */
    @Override
    public String toString() {
        String result = "";
//        for (Grille grille : this.Plateau) {
//            int[][] tableau = new int[TAILLE][TAILLE];
//            for (Case c : grille.getGrille()) {
//                tableau[c.getY()][c.getX()] = c.getValeur();
//            }
//            
//            for (int i = 0; i < tableau.length; i++) {
//                result += Arrays.toString(tableau[i]) + "\n";
//            }
//
//        }
//        return result;

        for (Grille grille1 : Plateau) {
            //grille1 = new Grille();// on crée
            //boolean b = newCell(); // on choisit une cass
            int[][] tab1 = new int[gridSize][gridSize];//on crée le tableau d'affichage
            for (Case c : grille1.getGrille()) { //parcourir le hashset 
                tab1[c.getY()][c.getX()] = c.getValeur();// récuperer la valeur
            };

            System.out.print(Arrays.deepToString(tab1) + "\t" + "\n");
        }
        return result;
    }

    /**
     * Getter
     * @return 
     */
    public Grille[] getPlateau() {
        return Plateau;
    }

    /**
     * Déplacement en profondeur
     * @param direction choisie par le joueur
     */
    public void Deplacement_Profondeur(int direction) {
        if (direction == PRO_LEFT) {
            //récuperer la position en cours
            System.out.println("+++++ Deplacement_Profondeur ++++++ " + direction);
        }
        if (direction == PRO_RIGHT) {

        }
    }

    /**
     * Demander au joueur avec quelle grille il souhaite jouer
     * @return la grille avec laquelle le joueur veut jouer
     */
    public Grille getGrille() {
        System.out.println("Avec quelle grille souhaitez-vous jouer ? (1, 2 ou 3)");
        Scanner r = new Scanner(System.in);
        //choix de grille
        int g = r.nextInt();
        if (g == 0) {
            return Plateau[0];
        } else if (g == 1) {
            return Plateau[1];
        } else if (g == 2) {
            return Plateau[2];
        }
        return null;

    }

//    @Override
//    public String toString() {
//        //afficher les 3 grilles
//        for (Grille Plateau1 : Plateau) {
//            System.out.print(Plateau1);
//        }
//
//        return null;
//    }
    
   /**
  * Getter
  * Permet l'accès en lecture à la valeur valeurMax 
  * @return retourne la valeur "valeurMax"
  */
    public int getValeurMax() {
        return valeurMax;
    }

    /**
     * 
     * @param direction choisie par le joueur
     * @return vrai si on a bougé après le déplacement, faux sinon
     */
    public boolean lanceurDeplacerCases(int direction) {
        Case[][] extremites = this.getCasesExtremites(direction);
        deplacement = false; // pour vérifier si on a bougé au moins une case après le déplacement, avant d'en rajouter une nouvelle
        for (int index = 0; index < gridSize; index++ /*Case[] extremite : extremites*/) {
            for (int i = 0; i < gridSize; i++) {
                switch (direction) {
                    case HAUT:
                        this.deplacerCasesRecursif(extremites[index], i, direction, 0, index);
                        break;
                    case BAS:
                        this.deplacerCasesRecursif(extremites[index], i, direction, 0, index);
                        break;
                    case GAUCHE:
                        this.deplacerCasesRecursif(extremites[index], i, direction, 0, index);
                        break;
                    case PRO_LEFT:
                        this.deplacerCasesRecursif(extremites[index], i, direction, 0, index);
                        break;
                    case PRO_RIGHT:
                        this.deplacerCasesRecursif(extremites[index], i, direction, 0, index);
                        break;
                    default:
                        this.deplacerCasesRecursif(extremites[index], i, direction, 0, index);
                        break;
                }
            }
        }

        return deplacement;
    }

    /**
     * Création d'une nouvelle case
     * @return vrai si la case est disponible pour générer un 2 ou un 4
     */
    
    public boolean newCell() {

        boolean[] newCell3D = new boolean[gridSize];

        for (int i = 0; i < Plateau.length; i++) {
            //on ajoute un nombre aléatoire si y a des cases libres 
            if (Plateau[i].getGrille().size() < gridSize * gridSize) {
                ArrayList<Case> casesLibres = new ArrayList<>();
                Random ra = new Random();
                int valeur = (1 + ra.nextInt(2)) * 2; //les nombres générés sont soit 0 soit 1 et il nous donne alors 2 ou 4 après l'ajout de 1 et la multiplication par 2
                // on crée toutes les cases encore libres
                for (int x = 0; x < gridSize; x++) {
                    for (int y = 0; y < gridSize; y++) {
                        Case c = new Case(x, y, valeur);
                        if (!Plateau[i].getGrille().contains(c)) { // contains utilise la méthode equals 
                            casesLibres.add(c);
                        }
                    }
                }
                // on en choisit une au hasard et on l'ajoute à la grille
                Case ajout = casesLibres.get(ra.nextInt(casesLibres.size()));
                ajout.setGrille(Plateau[i]);
                ajout.setGrille3D(this);
                Plateau[i].getGrille().add(ajout);
                if ((Plateau[i].getGrille().size() == 1) || (this.valeurMax == 2 && ajout.getValeur() == 4)) { // Mise à jour de la valeur maximale présente dans la grille si c'est la première case ajoutée ou si on ajoute un 4 et que l'ancien max était 2
                    this.valeurMax = ajout.getValeur();
                }
                newCell3D[i] = true;
            } else {
                newCell3D[i] = false;
            }
        }

        for (boolean b : newCell3D) {
            if (b == false) {
                return false;
            }
        }

        return true;
    }

    
    /**
     * Savoir si la partie est finie 
     * @return vrai si la partie est finie
     */
    public boolean partieFinie() {

        boolean[] grid3D = new boolean[gridSize];

        for (int i = 0; i < Plateau.length; i++) {
            if (Plateau[i].getGrille().size() < gridSize * gridSize) {
                grid3D[i] = false;
                //return false;
            } else {
                for (Case c : Plateau[i].getGrille()) {
                    for (int j = 1; j <= 2; j++) {
                        if (c.getVoisinDirect(j) != null) {
                            if (c.valeurEgale(c.getVoisinDirect(j))) {
                                grid3D[i] = false;
                            }
                        }
                    }
                }
            }
        }

        for (boolean b : grid3D) {
            if (b == false) {
                return false;
            }
        }

        return true;
    }

    /**
     * 
     * @param extremites extrémités d'une grille 
     * @param rangee  la ligne de déplacement 
     * @param direction choisie par le joueur
     * @param compteur donne le nombre de cases avec des extrémités 
     * @param index 
     */
    private void deplacerCasesRecursif(Case[] extremites, int rangee, int direction, int compteur, int index) {
        if (extremites[rangee] != null) {
            if ((direction == HAUT && extremites[rangee].getY() != compteur)
                    || (direction == BAS && extremites[rangee].getY() != gridSize - 1 - compteur)
                    || (direction == GAUCHE && extremites[rangee].getX() != compteur)
                    || (direction == DROITE && extremites[rangee].getX() != gridSize - 1 - compteur)) {
                this.Plateau[index].getGrille().remove(extremites[rangee]);
                switch (direction) {
                    case HAUT:
                        extremites[rangee].setY(compteur);
                        break;
                    case BAS:
                        extremites[rangee].setY(gridSize - 1 - compteur);
                        break;
                    case GAUCHE:
                        extremites[rangee].setX(compteur);
                        break;
                    case PRO_LEFT:
                        extremites[rangee].setX(compteur);
                        break;
                    case PRO_RIGHT:
                        extremites[rangee].setX(gridSize - 1 - compteur);
                        break;
                    default:
                        extremites[rangee].setX(gridSize - 1 - compteur);
                        break;
                }
                this.Plateau[index].getGrille().add(extremites[rangee]);
                deplacement = true;
            }

            Case voisin = extremites[rangee].getVoisinDirect3D(-direction, index, rangee);
            if (voisin != null) {
                if (extremites[rangee].valeurEgale(voisin)) {
                    this.fusion(extremites[rangee]);
                    extremites[rangee] = voisin.getVoisinDirect3D(-direction, index, rangee);
                    this.Plateau[index].getGrille().remove(voisin);
                    this.deplacerCasesRecursif(extremites, rangee, direction, compteur + 1, index);
                } else {
                    extremites[rangee] = voisin;
                    this.deplacerCasesRecursif(extremites, rangee, direction, compteur + 1, index);
                }
            }
        }
    }
    
/**
    * Détermine les cases qui ont des extrémités
    * @param direction choisie par le joueur
     * @return les extrémités d'une case
    */

    public Case[][] getCasesExtremites(int direction) {
        Case[][] result = new Case[gridSize][gridSize];
        for (int i = 0; i < result.length; i++) {
            for (Case c : Plateau[i].getGrille()) {
                switch (direction) {
                    case HAUT:
                        if ((result[i][c.getX()] == null) || (result[i][c.getX()].getY() > c.getY())) { // si on n'avait pas encore de case pour cette rangée ou si on a trouvé un meilleur candidat
                            result[i][c.getX()] = c;
                        }
                        break;
                    case BAS:
                        if ((result[i][c.getX()] == null) || (result[i][c.getX()].getY() < c.getY())) {
                            result[i][c.getX()] = c;
                        }
                        break;
                    case GAUCHE:
                        if ((result[i][c.getY()] == null) || (result[i][c.getY()].getX() > c.getX())) {
                            result[i][c.getY()] = c;
                        }
                        break;
                    case PRO_LEFT:
                        if ((result[i][c.getY()] == null) || (result[i][c.getY()].getX() > c.getX())) {
                            result[i][c.getY()] = c;
                        }
                        break;
                    case PRO_RIGHT:
                        if ((result[i][c.getY()] == null) || (result[i][c.getY()].getX() < c.getX())) {
                            result[i][c.getY()] = c;
                        }
                        break;
                    default:
                        if ((result[i][c.getY()] == null) || (result[i][c.getY()].getX() < c.getX())) {
                            result[i][c.getY()] = c;
                        }
                        break;
                }
            }
        }
        return result;
    }

      /**
     * Fusionne 2 cases 
     * (utile pour les mouvements)
     * @param c correspond à une case
     */
    private void fusion(Case c) {
        c.setValeur(c.getValeur() * 2);
        if (this.valeurMax < c.getValeur()) {
            this.valeurMax = c.getValeur();
        }
        deplacement = true;
    }

    /**
     * Message pour dire que le joueur a perdu
     */
    public void gameOver() {
        System.out.println("La partie est finie. Votre score est " + this.valeurMax);
        System.exit(1);
    }

    /**
     * Message pour dire que le joueur a gagné
     */
    public void victory() {
        System.out.println("Bravo ! Vous avez atteint " + this.valeurMax);
        System.exit(0);
    }
}
