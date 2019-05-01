/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hk_th
 */
public class Player {
    
     public int score;
     public boolean game_start;
     public int name;
     
     
    public Player(int name) {
        this.score = 1;
        this.game_start = false;
        this.name=name;
    }
    
    
    
    
}
