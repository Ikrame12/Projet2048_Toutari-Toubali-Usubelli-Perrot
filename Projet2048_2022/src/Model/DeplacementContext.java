/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public class DeplacementContext {
    private DeplacementStrategy strategy; 
    
    public DeplacementContext(DeplacementStrategy s) { 
        this.strategy = s; 
    } 

    public Direction executeStrategy() { 
        return this.strategy.next(); 
    }  

    public void setStrategy(DeplacementStrategy s) {
        this.strategy = s;
    }
}
