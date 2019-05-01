/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import snakesnladders.FXMLDocumentController;


/**
 *
 * @author hk_th
 */
public class Model {
    int inState=0;
    static public int finState=5;
    
     static ArrayList<Transition>[] transTable;
     static String[] pattern;
     static public  Player p1,p2,curPlayer;
     static public Level curlevel,l1,l2,l3;

    public Model(ArrayList<Transition>[] transTable, String[] pattern , Player p1 , Player p2 , Player curPlayer, Level l1, Level l2, Level l3) {
        this.transTable = transTable;
        this.pattern = pattern;
        this.p1=p1;
        this.p2=p2;
        this.curPlayer=curPlayer;
        this.l1=l1;
        this.l2=l2;
        this.l3=l3;
       
    }
    
    
    
   
      static public int dice=0;
      static public int curState=0;
     
      static public String pn1,pn2;
    
                  
   

    public static Random rand = new Random();
    
     
    
   public static  void diceroll()
    { 
        curState=1;
        
        /* do {
            gameStarter();
        
            System.out.println(curPlayer.name);
         /* if (curPlayer.game_start==false) {

             dice=rollDice();
             
             curState=transition(curState,dice);
                     System.out.println(dice);

             if (curState==1) {
                curPlayer.game_start=true; 
            }
              System.out.println(curPlayer.game_start);
        }
        
                
        if (curPlayer.game_start==true) {
            
            curState=1;
            //while (curState<2){
            
               dice=rollDice();
               System.out.println(dice);*/
               
             curState=transition(curState,dice);
             System.out.println(curState);
                if (curPlayer.score+dice<=100) {
                    
             curPlayer.score=curPlayer.score+dice;
            System.out.println(curPlayer.score);
                
            
            
            
        /*}}
            if (curPlayer==p1) {
                curPlayer=p2;
            }
            else
            { curPlayer=p1;}
            System.out.println("player chnage");
        } while(curState < 5);   
        System.out.println("player 1 "+p1.score);
        System.out.println("player 2 "+p2.score);*/ 
        
        }
    }
        

    
      public static int  transition(int state, int input )
    {
         for(int i=0;i<pattern.length;i++)
      {
          Pattern p=Pattern.compile(pattern[i]);
          Matcher match=p.matcher(String.valueOf(input));
          
          if (match.matches())
      {
          for (int j = 0; j < transTable[state].size(); j++) {
                       
                        if(transTable[state].get(j).pattern == input)
                        {
                           return transTable[state].get(j).state;
                        }
                    }
      }
      }
         return state;
    }
      public static boolean positionChecker(){
          
                    
                for (int i = 0; i < curlevel.down.length; i++) {
                    if (curPlayer.score==curlevel.down[i]) {
                        curState=transition(curState,0);
                        curPlayer.score=checkSnake(curPlayer.score);
                        if (curlevel==l3) {
                            System.out.println("ufo");
                            
                            Sound.ufo.play();
                        }else{
                        System.out.println("snake");
                        
                        Sound.snake.play();
                       
                        }
                        return true;
                    }
                    
                }
                for (int i = 0; i < curlevel.up.length; i++) {
                    if (curPlayer.score==curlevel.up[i]) {
                        curState=transition(curState,1);
                        curPlayer.score=checkLadder(curPlayer.score);
                        if (curlevel==l3) {
                            System.out.println("rocket");
                            
                            Sound.rocket.play();
                        }else{
                            System.out.println("ladder");
                            
                            Sound.ladder.play();;
                        }
                    return true;
                    }
                }
                    if (curPlayer.score==100) {
                        curState=transition(curState,2);
                        System.out.println("win");
                        
                       }
                
                
          return false;
      }
     
     public static void gameStarter(){
         
         //dice=rollDice();
        if (dice==6) {
             curState=1;
             curPlayer.game_start=true; 
          }
       }
     
     public static int rollDice(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Model.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return rand.nextInt((6 - 1) + 1) + 1;
     }
    
      public static int checkSnake(int position ){
        
        for (int i = 0; i < curlevel.down.length; i++) {
            if (position== curlevel.down[i]) {
                position = curlevel.down2[i];            }
        }
       return position; 
    }
    
     public static int checkLadder(int position ){
        
        for (int i = 0; i < curlevel.up.length; i++) {
            if (position== curlevel.up[i]) {
                position = curlevel.up1[i];            }
        }
       return position; 
    }    
        
    
    
                       
   }

