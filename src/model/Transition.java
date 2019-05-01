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
public class Transition {
    
    
    int state;
    int pattern;

    public Transition() {
        this.state=0;
        this.pattern=0;
        }
    
     public Transition(int state, int pattern) {
        this.state = state;
        this.pattern = pattern;
    }
  
}
