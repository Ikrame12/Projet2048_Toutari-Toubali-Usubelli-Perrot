/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javamysqlconnect;

/**
 *Initialisation d'un utilisateur
 */
public class Utilisateur {
    private String pseudo;
    private int score;
    
   /**
    * Constructeur de la classe Utilisateur 
    * @param p pseudo de l'utilisateur / joueur
    * @param s score de l'utilisateur / joueur
    */ 
    public Utilisateur(String  p, int s){
        this.pseudo=p;
        this.score=s;   
    }

      /**
  * Getter
  * Permet l'accès en lecture à la valeur "pseudo"
  * @return retourne le pseudo
  */
    public String getPseudo() {
        return pseudo;
    }
    
  /**
  * Setter
  * Permet de demander un changement d'état du paramètre "pseudo"
  * @param pseudo pseudo du joueur
  */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

      /**
  * Getter
  * Permet l'accès en lecture à la valeur "score"
  * @return retourne la valeur du score
  */
    public int getScore() {
        return score;
    }

     /**
  * Setter
  * Permet de demander un changement d'état du paramètre "score"
  * @param score score du joueur
  */
    public void setScore(int score) {
        this.score = score;
    }
    
}
