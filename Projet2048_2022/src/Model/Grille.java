/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Parametres;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;



/**
 *
 * Représentation d'une grille
 */
public class Grille implements Parametres {

    private final HashSet<Case> grille;
    private int valeurMax = 0;
    private boolean deplacement;

    /**
     * Constructeur d'une grille
     */
    public Grille() {
        this.grille = new HashSet<>();
    }

    /**
     * Affichage des grilles 
     * @return les grilles 
     */
    @Override
    public String toString() {
        int[][] tableau = new int[TAILLE][TAILLE];
        for (Case c : this.grille) {
            tableau[c.getY()][c.getX()] = c.getValeur();
        }
        String result = "";
        for (int i = 0; i < tableau.length; i++) {
            result += Arrays.toString(tableau[i]) + "\n";
        }
        return result;
    }

 
/**
 * 
 * @return une grille
 */
    public HashSet<Case> getGrille() {
        return grille;
    }

    /**
     * Getter 
     * Permet l'accès en lecture à la valeur "valeurMax"
     * @return la plus grand valeur de la grille
     */
    public int getValeurMax() {
        return valeurMax;
    }
/**
 * 
 * @return vrai si la partie est finie, faux sinon
 */
    public boolean partieFinie() {
        if (this.grille.size() < TAILLE * TAILLE) {
            System.out.println("++ HCN partieFinie :this.grille.size(): ++ "+this.grille.size());
            return false;
        } else {
            for (Case c : this.grille) {
                for (int i = 1; i <= 2; i++) {
                    if (c.getVoisinDirect(i) != null) {
                        System.out.println("++ HCN partieFinie :this.grille.size(): ++ "+this.grille.size());
                        System.out.println("++ HCN partieFinie :c.getVoisinDirect(i): ++ "+c.getVoisinDirect(i));
                        if (c.valeurEgale(c.getVoisinDirect(i))) {


                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
/**
 * 
 * @param direction choisie par le joueur
 * @return vrai si on a bougé après le déplacement, faux sinon
 */
    public boolean lanceurDeplacerCases(int direction) {
        Case[] extremites = this.getCasesExtremites(direction);
        deplacement = false; // pour vérifier si on a bougé au moins une case après le déplacement, avant d'en rajouter une nouvelle
        for (int i = 0; i < TAILLE; i++) {
            System.out.println("jeu2048.l2.Grille.lanceurDeplacerCases() ==== i "+i);
            switch (direction) {
                case HAUT:
                    this.deplacerCasesRecursif(extremites, i, direction, 0);
                    break;
                case BAS:
//                    for (Case extremite : extremites) {
//                        System.out.println("jeu2048.l2.Grille.lanceurDeplacerCases() :extremite: "+extremite);
//                    }
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
     *
     * @param extremites extrémités d'une grille
     * @param rangee la ligne de déplacement 
     * @param direction choisie par le joueur
     * @param compteur donne le nombre de cases avec des extrémités 
     */
    private void deplacerCasesRecursif(Case[] extremites, int rangee, int direction, int compteur) {

        if (extremites[rangee] != null) {
            System.out.println("jeu2048.l2.Grille.deplacerCasesRecursif() :extremites[rangee]: "+extremites[rangee]);
            if ((direction == HAUT && extremites[rangee].getY() != compteur)
                    || (direction == BAS && extremites[rangee].getY() != TAILLE - 1 - compteur)
                    || (direction == GAUCHE && extremites[rangee].getX() != compteur)
                    || (direction == DROITE && extremites[rangee].getX() != TAILLE - 1 - compteur)) {
//                System.out.println("deplacerCasesRecursif X => "+extremites[rangee].getX());
//                System.out.println("deplacerCasesRecursif Y => "+extremites[rangee].getY());
                System.out.println("deplacerCasesRecursif compteur => "+compteur);
//                System.out.println("deplacerCasesRecursif rangee => "+rangee);
//                System.out.println("deplacerCasesRecursif extremites => "+extremites.toString());
                this.grille.remove(extremites[rangee]);
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
                this.grille.add(extremites[rangee]);
                deplacement = true;
            }
            Case voisin = extremites[rangee].getVoisinDirect(-direction);
//            System.out.println("jeu2048.l2.Grille.deplacerCasesRecursif() :voisin: "+voisin);
            if (voisin != null) {
                if (extremites[rangee].valeurEgale(voisin)) {
                    this.fusion(extremites[rangee]);
                    extremites[rangee] = voisin.getVoisinDirect(-direction);
                    this.grille.remove(voisin);
                    this.deplacerCasesRecursif(extremites, rangee, direction, compteur + 1);
                } else {
                    extremites[rangee] = voisin;
                    this.deplacerCasesRecursif(extremites, rangee, direction, compteur + 1);
                }
            }
        }
    }


    /**
     * Détermine les cases qui ont des extrémités
     * @param direction choisie par le joueur
      * @return les extrémités d'une case
     */
    public Case[] getCasesExtremites(int direction) {
        Case[] result = new Case[TAILLE];
        for (Case c : this.grille) {
            switch (direction) {
                case HAUT:
                    if ((result[c.getX()] == null) || (result[c.getX()].getY() > c.getY())) { // si on n'avait pas encore de case pour cette rangée ou si on a trouvé un meilleur candidat
                        result[c.getX()] = c;
                    }
                    break;
                case BAS:
                    if ((result[c.getX()] == null) || (result[c.getX()].getY() < c.getY())) {
                        result[c.getX()] = c;
//                        System.out.println("jeu2048.l2.Grille.getCasesExtremites() :c: "+c.toString());
//                        System.out.println("jeu2048.l2.Grille.getCasesExtremites() :result[c.getX()]: "+result[c.getX()]);
//                        System.out.println("jeu2048.l2.Grille.getCasesExtremites() :result[c.getY()]: "+result[c.getY()]);
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
//        for (Case case1 : result) {
//           System.out.println("++ HCN getCasesExtremites :result Case: ++ "+case1);
//        }

        return result;
    }

    /**
     * Message pour dire que le joueur a perdu la partie
     */
    public void victory() {
        System.out.println("Bravo ! Vous avez atteint " + this.valeurMax);
        System.exit(0);
    }

    /**
     * Message pour dire que le joueur a perdu la partie
     */
    public void gameOver() {
        System.out.println("La partie est finie. Votre score est " + this.valeurMax);
        System.exit(1);
    }


  
}
