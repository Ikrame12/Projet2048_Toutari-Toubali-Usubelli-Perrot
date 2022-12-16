/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Parametres;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Sylvain
 */
/**
 * Initialisation d'une case
 *
 */
public class Case implements Parametres {

    private int x, y, valeur;
    private Grille grille;
    private Grille3D grille3D;



  /**
  * Constructeur de la classe Case
  * @param abs correspond à l'abcisse de la case
  * @param ord correspond à l'odonnee de la case
  * @param v   correspond à la valeur dans la case
  */
    public Case(int abs, int ord, int v) {
        this.x = abs;   // déplacement horizontal
        this.y = ord;   // déplacement vertical
        this.valeur = v;    // valeur de la case
    }

    // Création des setters et des getters

    /**
  * Setter
  * Permet de demander un changement d'état du paramètre "g"
  * @param g grille
  */
    public void setGrille(Grille g) {
        this.grille = g;
    }

    /**
     * Permet de demander un changement d'état du paramètre "g"
     * @param g grille3D
     */
    public void setGrille3D(Grille3D g) {
        this.grille3D = g;
    }

    /**
  * Getter
  * Permet l'accès en lecture à la valeur x
  * @return retourne la valeur x
  */

    public int getX() {
        return this.x;
    }


    /**
  * Getter
  * Permet l'accès en lecture à la valeur y
  * @return retourne la valeur y
  */
    public int getY() {
        return this.y;
    }


    /**
  * Setter
  * Permet de demander un changement d'état du paramètre "x"
  * @param x l'abcisse de la case
  */
    public void setX(int x) {
        this.x = x;
    }

 /**
  * Setter
  * Permet de demander un changement d'état du paramètre "y"
  * @param y l'ordonnée de la case
  */
    public void setY(int y) {
        this.y = y;
    }

     /**
  * Setter
  * Permet de demander un changement d'état du paramètre "valeur"
  * @param valeur valeur de la case
  */
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }


     /**
  * Getter
  * Permet l'accès en lecture à la valeur "valeur"
  * @return retourne la valeur de valeur
  */
    public int getValeur() {
        return this.valeur;
    }

     /**
  * Vérifie si les cases sont égales
  * @param obj paramètre comparé à la case
  * @return vrai si les cases (ordonnees et abscisses) sont égales
  */
    @Override
    public boolean equals(Object obj) { // la méthode equals est utilisée lors de l'ajout d'une case à un ensemble pour vérifier qu'il n'y a pas de doublons (teste parmi tous les candidats qui ont le même hashcode)
        if (obj instanceof Case) {
            Case c = (Case) obj;
            return (this.x == c.x && this.y == c.y);
        } else {
            return false;
        }
    }


    /**
     * Déclaration du hashcode
     *
     */
    @Override
    public int hashCode() { // détermine le hashcode
        return this.x * 7 + this.y * 13;
    }

   /**
 * Indique ce qu'il faut faire si les valeurs de 2 cases sont égales
 * @param c paramètre comparé à la valeur de la case
 * @return vraie si les valeurs sont égales
 */
    public boolean valeurEgale(Case c) {
        if (c != null) {
            return this.valeur == c.valeur;
        } else {
            return false;
        }
    }


    /**
     *
     * @param direction choisie par le joueur (gauche / droite / haut / bas)
     * @return la case voisine à la case dans laquelle le joueur se trouve en fonction de la direction qu'il a choisi.
     * Par exemple, si le joueur choisi la direction "gauche" cette fonction regardera la case de gauche par rapport à la case actuelle.
     */

    public Case getVoisinDirect(int direction) {
        //System.out.println("jeu2048.l2.Case.getVoisinDirect() ==== direction "+direction);
        if (direction == HAUT) {
            for (int i = this.y - 1; i >= 0; i--) {
                System.out.println("jeu2048.l2.Case.getVoisinDirect() ==== i " + i);
                for (Case c : grille.getGrille()) {
                    if (c.getX() == this.x && c.getY() == i) {
                        return c;
                    }
                }
            }
        } else if (direction == BAS) {
            for (int i = this.y + 1; i < TAILLE; i++) {
                for (Case c : grille.getGrille()) {
                    if (c.getX() == this.x && c.getY() == i) {
                        return c;
                    }
                }
            }
        } else if (direction == GAUCHE) {
            for (int i = this.x - 1; i >= 0; i--) {
                for (Case c : grille.getGrille()) {
                    if (c.getX() == i && c.getY() == this.y) {
                        return c;
                    }
                }
            }
        } else if (direction == DROITE) {
            for (int i = this.x + 1; i < TAILLE; i++) {
                for (Case c : grille.getGrille()) {
                    if (c.getX() == i && c.getY() == this.y) {
                        return c;
                    }
                }
            }
        }
        return null;
    }





  /**
   *
   * @param direction choisie par le joueur (gauche / droite / haut / bas / profondeur gauche / profondeur droite)
   * @param index
   * @param rangee
   * @return la case voisine à la case dans laquelle le joueur se trouve en fonction de la direction qu'il a choisi.
   */


    public Case getVoisinDirect3D(int direction, int index, int rangee) {

        if (direction == HAUT) {
            List<Case> y1 = new ArrayList<>();
            List<Case> y2 = new ArrayList<>();
            List<Case> y3 = new ArrayList<>();

            for (int i = 0; i < 3; i++) {

                HashSet<Case> cases = grille3D.getPlateau()[i].getGrille();
                for (Case aCase : cases) {
                    if (aCase.getY() == 0) {
                        y1.add(aCase);
                    }
                    if (aCase.getY() == 1) {
                        y2.add(aCase);
                    }
                    if (aCase.getY() == 2) {
                        y3.add(aCase);
                    }

                }
            }

            Case[] cases1 = new Case[gridSize * gridSize];
            Case[] cases2 = new Case[gridSize * gridSize];
            Case[] cases3 = new Case[gridSize * gridSize];
            y1.toArray(cases1);
            y2.toArray(cases2);
            y3.toArray(cases3);

            List<Case[]> listcases = new ArrayList<>();
            listcases.add(cases1);
            listcases.add(cases2);
            listcases.add(cases3);


            for (int i = this.y + 1; i < gridSize; i++) {
                for (int j = 0; j < listcases.size(); j++) {
                    if (i == j) {
                        for (Case c : listcases.get(j)) {
                            if (c!= null && c.getX() == this.x && c.getY() == j) {
                                return c;
                            }
                        }
                    }

                }

            }

        } else if (direction == BAS) {
            List<Case> y1 = new ArrayList<>();
            List<Case> y2 = new ArrayList<>();
            List<Case> y3 = new ArrayList<>();

            for (int i = 0; i < 3; i++) {

                HashSet<Case> cases = grille3D.getPlateau()[i].getGrille();
                for (Case aCase : cases) {
                    if (aCase.getY() == 0) {
                        y1.add(aCase);
                    }
                    if (aCase.getY() == 1) {
                        y2.add(aCase);
                    }
                    if (aCase.getY() == 2) {
                        y3.add(aCase);
                    }

                }
            }

            Case[] cases1 = new Case[gridSize * gridSize];
            Case[] cases2 = new Case[gridSize * gridSize];
            Case[] cases3 = new Case[gridSize * gridSize];
            y1.toArray(cases1);
            y2.toArray(cases2);
            y3.toArray(cases3);

            List<Case[]> listcases = new ArrayList<>();
            listcases.add(cases1);
            listcases.add(cases2);
            listcases.add(cases3);


            for (int i = this.y + 1; i < gridSize; i++) {
                for (int j = 0; j < listcases.size(); j++) {
                    if (i == j) {
                        for (Case c : listcases.get(j)) {
                            if (c!= null && c.getX() == this.x && c.getY() == j) {
                                return c;
                            }
                        }
                    }

                }

            }
        } else if (direction == GAUCHE) {
            for (int i = this.x - 1; i >= 0; i--) {
                for (Case c : grille.getGrille()) {
                    if (c.getX() == i && c.getY() == this.y) {
                        return c;
                    }
                }
            }
        } else if (direction == DROITE) {
            for (int i = this.x + 1; i < gridSize; i++) {
                for (Case c : grille.getGrille()) {
                    if (c.getX() == i && c.getY() == this.y) {
                        return c;
                    }
                }
            }
        } else if (direction == PRO_LEFT) {
            List<Case> y1 = new ArrayList<>();
            List<Case> y2 = new ArrayList<>();
            List<Case> y3 = new ArrayList<>();

            for (int i = 0; i < 3; i++) {

                HashSet<Case> cases = grille3D.getPlateau()[i].getGrille();
                for (Case aCase : cases) {
                    if (aCase.getX() == 0) {
                        y1.add(aCase);
                    }
                    if (aCase.getX() == 1) {
                        y2.add(aCase);
                    }
                    if (aCase.getX() == 2) {
                        y3.add(aCase);
                    }

                }
            }

            Case[] cases1 = new Case[gridSize * gridSize];
            Case[] cases2 = new Case[gridSize * gridSize];
            Case[] cases3 = new Case[gridSize * gridSize];
            y1.toArray(cases1);
            y2.toArray(cases2);
            y3.toArray(cases3);

            List<Case[]> listcases = new ArrayList<>();
            listcases.add(cases1);
            listcases.add(cases2);
            listcases.add(cases3);


            for (int i = this.x + 1; i < gridSize; i++) {
                for (int j = 0; j < listcases.size(); j++) {
                    if (i == j) {
                        for (Case c : listcases.get(j)) {
                            if (c!= null && c.getY() == this.y && c.getX() == j) {
                                return c;
                            }
                        }
                    }

                }

            }
        } else if (direction == PRO_RIGHT) {

            List<Case> y1 = new ArrayList<>();
            List<Case> y2 = new ArrayList<>();
            List<Case> y3 = new ArrayList<>();

            for (int i = 0; i < 3; i++) {

                HashSet<Case> cases = grille3D.getPlateau()[i].getGrille();
                for (Case aCase : cases) {
                    if (aCase.getX() == 0) {
                        y1.add(aCase);
                    }
                    if (aCase.getX() == 1) {
                        y2.add(aCase);
                    }
                    if (aCase.getX() == 2) {
                        y3.add(aCase);
                    }

                }
            }

            Case[] cases1 = new Case[gridSize * gridSize];
            Case[] cases2 = new Case[gridSize * gridSize];
            Case[] cases3 = new Case[gridSize * gridSize];
            y1.toArray(cases1);
            y2.toArray(cases2);
            y3.toArray(cases3);

            List<Case[]> listcases = new ArrayList<>();
            listcases.add(cases1);
            listcases.add(cases2);
            listcases.add(cases3);

            for (int i = this.x + 1; i < gridSize; i++) {
                for (int j = 0; j < listcases.size(); j++) {
                    if (i == j) {
                        for (Case c : listcases.get(j)) {
                            if (c!= null && c.getY() == this.y && c.getX() == j) {
                                return c;
                            }
                        }
                    }

                }

            }
        }
        return null;
    }


     /**
  * Redéfinition de la méthode String
  *
  */
    @Override
    public String toString() {
        return "Case(" + this.x + "," + this.y + "," + this.valeur + ")";
    }

}
