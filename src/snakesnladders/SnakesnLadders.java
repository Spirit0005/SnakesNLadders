/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesnladders;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import model.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Level;
import model.Model;
import model.Sound;
import sun.audio.*;
/**
 *
 * @author hk_th
 */
public class SnakesnLadders extends Application {
    
        static Stage stg;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        
        Scene scene = new Scene(root);
        this.stg=stage;
        stg.setScene(scene);
        stg.getIcons().add(new Image("/images/icon.png"));
        stg.setTitle("Snake And Ladders");

        stg.show();
    }
    
    
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        
         ArrayList<model.Transition>[] transTable=new ArrayList[6];
     String[] pattern= new String[]{"[1-6]"}; 
     for(int i=0;i<transTable.length;i++)
    {
     transTable[i]=new ArrayList<model.Transition>();
    }
        
    transTable[0].add(new model.Transition(1,6));
    //transTable[0].add(new model.Transition(1,1));
    transTable[1].add(new  model.Transition(1,6));
    transTable[1].add(new  model.Transition(2,1));
    transTable[1].add(new  model.Transition(2,2));
    transTable[1].add(new  model.Transition(2,3));
    transTable[1].add(new  model.Transition(2,4));
    transTable[1].add(new  model.Transition(2,5));
    transTable[2].add(new  model.Transition(1,6));
    transTable[2].add(new  model.Transition(3,0));
    transTable[2].add(new  model.Transition(4,1));
    transTable[2].add(new  model.Transition(5,2));
    //transTable[3].add(new  model.Transition(1,"t"));
    //transTable[4].add(new  model.Transition(1,"t"));
        
         
        
        
        int[] snake = new int[]{43,50,56,73,84,87,98};
        int[] s_tail = new int[]{17,5,8,15,58,49,40};
        int[] ladder = new int[]{2,6,20,52,57,71};
        int[] l_head = new int[]{23,45,59,72,96,92};
        
        int[] snake1 = new int[]{43,50,56,58,73,77,82,84,87,93,98};
        int[] s_tail1 = new int[]{17,5,8,37,15,3,62,58,49,31,40};
        int[] ladder1 = new int[]{2,4,6,20,30,52,57,71};
        int[] l_head1 = new int[]{23,68,45,59,95,72,96,92};
        
        int[] snake2= new int[]{56,62,76,88,91,97};
        int[] s_tail2= new int[]{2,25,9,52,65,79};
        int[] ladder2 = new int[]{4,5,14,21,30,43,61,92};
        int[] l_head2 = new int[]{68,8,84,59,95,90,64,95};
        
        Player p1=new Player(11);
        Player p2=new Player(12);
        Player curPlayer=new Player(0);
        
        Level level1=new Level(ladder,l_head,snake,s_tail);
        Level level2=new Level(ladder1,l_head1,snake1,s_tail1);
        Level level3=new Level(ladder2,l_head2,snake2,s_tail2);
       
            
       Model model=new Model(transTable,pattern,p1,p2,p1,level1,level2,level3);
    
        
       Sound.intro.loop();
      
        launch(args);
           }
    
}
