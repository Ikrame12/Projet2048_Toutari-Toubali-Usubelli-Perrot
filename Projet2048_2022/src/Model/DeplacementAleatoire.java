/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;

/**
 * Déplacement aléatoire
 */
public class DeplacementAleatoire implements DeplacementStrategy {
    
    @Override
    public Direction next() {
        Direction[] directionspossibles = Direction.values();
        Random ra = new Random();
        return directionspossibles[ra.nextInt(4)];
    }
    
}
