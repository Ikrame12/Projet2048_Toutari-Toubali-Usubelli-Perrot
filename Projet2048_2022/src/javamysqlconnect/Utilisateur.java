/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javamysqlconnect;

/**
 *
 * @author ikram
 */
public class Utilisateur {
    private String pseudo;
    private int score;
    
    public Utilisateur(String  p, int s){
        this.pseudo=p;
        this.score=s;   
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
}
