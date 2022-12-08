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
 * @author HOUCINE
 */
public class Grille3D implements Parametres { //classe pour initialiser la grille 3D

    private Grille[] Plateau;// = new Grille[3];

    private int valeurMax = 0;
    private boolean deplacement;

    public Grille3D() { //méthode pour afficher le plateau
        //System.out.println("jeu2048.l2.Grille3D.<init>() this. "+this.Plateau.toString());
        Grille grille1 = new Grille();
        Grille grille2 = new Grille();
        Grille grille3 = new Grille();
        this.Plateau = new Grille[TAILLE];
        this.Plateau[0] = grille1;
        this.Plateau[1] = grille2;
        this.Plateau[2] = grille3;
        //System.out.println("jeu2048.l2.Grille3D.<init>() this. "+this.Plateau[0].toString());
    }

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
            int[][] tab1 = new int[TAILLE][TAILLE];//on crée le tableau d'affichage
            for (Case c : grille1.getGrille()) { //parcourir le hashset 
                tab1[c.getY()][c.getX()] = c.getValeur();// récuperer la valeur
            };

            System.out.print(Arrays.deepToString(tab1) + "\t" + "\n");
        }
        return result;
    }

    public void DisplayGrid() {
        for (Grille Plateau1 : Plateau) {
            int[][] tableau = new int[3][3];
            Plateau1.getGrille().forEach(c -> {
                tableau[c.getY()][c.getX()] = c.getValeur();
            });
            for (int[] tableau1 : tableau) {
                Arrays.toString(tableau1);
            }
            System.out.print("\n");
        }

    }

    public Grille[] getPlateau() {
        return Plateau;
    }



    //demander quelle grille
    public Grille getGrille() {
        System.out.println("Vous voulez quel grille?(1-2-3)");
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
    public int getValeurMax() {
        return valeurMax;
    }

    public boolean lanceurDeplacerCases(int direction) {
        Case[][] extremites = this.getCasesExtremites(direction);
        deplacement = false; // pour vérifier si on a bougé au moins une case après le déplacement, avant d'en rajouter une nouvelle
        for (int index=0; index<TAILLE; index++ /*Case[] extremite : extremites*/) {
            for (int i = 0; i < TAILLE; i++) {
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
                default:
                    this.deplacerCasesRecursif(extremites[index], i, direction, 0, index);
                    break;
            }
        }
        }
        
        return deplacement;
    }

    public boolean newCell() {

        boolean[] newCell3D = new boolean[TAILLE];

        for (int i = 0; i < Plateau.length; i++) {
            //on ajoute un nombre aléatoire si y a des cases libres 
            if (Plateau[i].getGrille().size() < TAILLE * TAILLE) {
                ArrayList<Case> casesLibres = new ArrayList<>();
                Random ra = new Random();
                int valeur = (1 + ra.nextInt(2)) * 2; //les nombres générés sont soit 0 soit 1 et il nous donne alors 2 ou 4 après l'ajout de 1 et la multiplication par 2
                // on crée toutes les cases encore libres
                for (int x = 0; x < TAILLE; x++) {
                    for (int y = 0; y < TAILLE; y++) {
                        Case c = new Case(x, y, valeur);
                        if (!Plateau[i].getGrille().contains(c)) { // contains utilise la méthode equals 
                            casesLibres.add(c);
                        }
                    }
                }
                // on en choisit une au hasard et on l'ajoute à la grille
                Case ajout = casesLibres.get(ra.nextInt(casesLibres.size()));
                ajout.setGrille(Plateau[i]);
                //System.out.println(ajout);
                Plateau[i].getGrille().add(ajout);
                if ((Plateau[i].getGrille().size() == 1) || (this.valeurMax == 2 && ajout.getValeur() == 4)) { // Mise à jour de la valeur maximale présente dans la grille si c'est la première case ajoutée ou si on ajoute un 4 et que l'ancien max était 2
                    this.valeurMax = ajout.getValeur();
                }
                //return true;
                newCell3D[i] = true;
            } else {
                //return false;
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

    public boolean partieFinie() {

        boolean[] grid3D = new boolean[TAILLE];

        for (int i = 0; i < Plateau.length; i++) {
            if (Plateau[i].getGrille().size() < TAILLE * TAILLE) {
                //System.out.println("++ Hajar partieFinie :this.grille.size(): ++ " + Plateau[i].getGrille().size());
                grid3D[i] = false;
                //return false;
            } else {
                for (Case c : Plateau[i].getGrille()) {
                    for (int j = 1; j <= 2; j++) {
                        if (c.getVoisinDirect(j) != null) {
                            //System.out.println("++ Hajar partieFinie :this.grille.size(): ++ " + Plateau[i].getGrille().size());
                            //System.out.println("++ Hajar partieFinie :c.getVoisinDirect(i): ++ " + c.getVoisinDirect(j));
                            if (c.valeurEgale(c.getVoisinDirect(j))) {
                                //return false;
                                grid3D[i] = false;
                            }
                        }
                    }
                }
            }

            //return true; 
            //grid3D[i] = true;
        }

        for (boolean b : grid3D) {
            //System.out.println("++ HCN partieFinie :: +b+ " + b);
            if (b == false) {
                return false;
            }
        }

        return true;
    }
    private void deplacerCasesRecursif(Case[] extremites, int rangee, int direction, int compteur, int index) {
        if (extremites[rangee] != null) {
            if ((direction == HAUT && extremites[rangee].getY() != compteur)
                    || (direction == BAS && extremites[rangee].getY() != TAILLE - 1 - compteur)
                    || (direction == GAUCHE && extremites[rangee].getX() != compteur)
                    || (direction == DROITE && extremites[rangee].getX() != TAILLE - 1 - compteur)) {
                this.Plateau[index].getGrille().remove(extremites[rangee]);
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
                this.Plateau[index].getGrille().add(extremites[rangee]);
                deplacement = true;
            }
            Case voisin = extremites[rangee].getVoisinDirect(-direction);
            if (voisin != null) {
                if (extremites[rangee].valeurEgale(voisin)) {
                    this.fusion(extremites[rangee]);
                    extremites[rangee] = voisin.getVoisinDirect(-direction);
                    this.Plateau[index].getGrille().remove(voisin);
                    this.deplacerCasesRecursif(extremites, rangee, direction, compteur + 1, index);
                } else {
                    extremites[rangee] = voisin;
                    this.deplacerCasesRecursif(extremites, rangee, direction, compteur + 1, index);
                }
            }
        }
    }
//    
    public Case[][] getCasesExtremites(int direction) {
        Case[][] result = new Case[TAILLE][TAILLE];
        for (int i=0; i<result.length; i++) {
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
                        if ((result[i][c.getY()] == null) || (result[c.getY()][i].getX() > c.getX())) {
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

        for (int i=0; i<result.length; i++ ) {
            System.out.println("++ Hajar getCasesExtremites :i: ++ " + i);
            for (int j=0; j<result[i].length ; j++) {
                System.out.println("++ Hajar getCasesExtremites :result[i].length: ++ " + result[i].length);
                System.out.println("++ Hajar getCasesExtremites :j: ++ " + j);
                if(result[i][j] != null){
                    System.out.println("++ Hajar getCasesExtremites :result[i][j]: ++ " + result[i][j]);
                }
                
            }
            System.out.println("-------------------------------------------------------");
        }
        
        
        //System.out.println("++ Hajar getCasesExtremites :result[2]: ++ " + result[2].toString());
        return result;
    }
    
    private void fusion(Case c) {
     c.setValeur(c.getValeur() * 2);
     if (this.valeurMax < c.getValeur()) {
        this.valeurMax = c.getValeur();
        }
        deplacement = true;
    }
    
    public void gameOver() {
        System.out.println("La partie est finie. Votre score est " + this.valeurMax);
        System.exit(1);
    }
    
    public void victory() {
        System.out.println("Bravo ! Vous avez atteint " + this.valeurMax);
        System.exit(0);
    }
}
