/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesnladders;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Model;
import model.Sound;
import static model.Sound.*;
import static snakesnladders.SnakesnLadders.stg;
/**
 *
 * @author hk_th
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label player1,player2,score1,score2,roll,lvl,lvl1,lvl2,lvl3,l1;
   
    
    @FXML
    private GridPane grid;
    @FXML
    private JFXButton move;
    @FXML
    private ImageView dice,turn,back,start,p1,p2,img,win1,lv1,lv2,lv3,game;
    @FXML 
    JFXTextField t1,t2;
    @FXML
    Text win2;
     Boolean bool;
    
    
    @FXML
    private void home() throws IOException{
        Sound.click.play();
        stg.hide();
            Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
       
        Scene scene = new Scene(root);
        
        stg.setScene(scene);
        
        stg.show();
        
    }
    @FXML
    private void level1() throws IOException{
        
          Sound.click.play();
          Model.pn1 = t1.getText();
          Model.pn2 = t2.getText();
          Model.curlevel=Model.l1;
        stg.hide();
        
            Parent root = FXMLLoader.load(getClass().getResource("Level1.fxml"));
        
        Scene scene = new Scene(root);
        
        stg.setScene(scene);
        
        stg.show();
        Sound.intro.stop();
        Sound.level1.loop();
       
       
    }
    
    @FXML
    private void level2() throws IOException{
        
          Sound.click.play();
          Model.pn1 = t1.getText();
          Model.pn2 = t2.getText();
          Model.curlevel=Model.l2;
        stg.hide();
        
            Parent root = FXMLLoader.load(getClass().getResource("Level2.fxml"));
        
        Scene scene = new Scene(root);
        
        stg.setScene(scene);
        
        stg.show();
        Sound.intro.stop();
        Sound.level2.loop();
       
    }
    
     @FXML
    private void level3() throws IOException{
        
          Sound.click.play();
          Model.pn1 = t1.getText();
          Model.pn2 = t2.getText();
          Model.curlevel=Model.l3;
        stg.hide();
        
            Parent root = FXMLLoader.load(getClass().getResource("Level3.fxml"));
        
        Scene scene = new Scene(root);
        
        stg.setScene(scene);
        
        stg.show();
       Sound.intro.stop();
        Sound.level3.loop();
       
    }
    
    @FXML
    private void player() throws IOException{
        Sound.click.play();
        stg.hide();
         
            Parent root = FXMLLoader.load(getClass().getResource("Player.fxml"));
       
        Scene scene = new Scene(root);
        
        stg.setScene(scene);
        //Sound.sound1.stop();
        stg.show();
    }
    
    
    
    @FXML
    private void setName(){
       
        //System.out.println(Model.pn1);
       player1.setText(Model.pn1);
        player2.setText(Model.pn2);
    }
    @FXML
    private void exitGame() {
        Sound.click.play();
        System.exit(0);
    }
    
    
    @FXML
    private void rollDice(){
     
        Sound.diceroll.play();
        fade(turn);
        Model.dice=Model.rollDice();
        l1.setText(String.valueOf(Model.dice));
        
        if (Model.curPlayer.game_start==false) {
            
            Model.gameStarter();
            
            
        }
        else{
        if(Model.curPlayer.game_start==true)
        {
            
             Model.diceroll();
             move.setDisable(false);
             dice.setVisible(false);
        } 
        
        score1.setText(String.valueOf(Model.p1.score));
        score2.setText(String.valueOf(Model.p2.score));
        
         if (Model.curState==Model.finState && Model.dice<6) {
             System.out.println("win");  
            
        }
        }
          if (Model.curPlayer.game_start==false) {
        turnChanger();
          }
         
      }
    
    @FXML
    private void movePiece() throws InterruptedException {
       //ImageView img=new ImageView();
        //p1.setManaged(true);
       // TimeUnit.SECONDS.sleep(1);
        Sound.click.play();
        if (Model.curPlayer== Model.p1) {
            img=p1;
        }else
        {
            img=p2;
        }
        
        grid.getChildren().remove(img);
        if (Model.curPlayer.score==2) {
            grid.add(img,1,9);
           }
        if (Model.curPlayer.score==3) {
            grid.add(img,2,9);
           }
        if (Model.curPlayer.score==4) {
            grid.add(img,3,9);
           }
        if (Model.curPlayer.score==5) {
            grid.add(img,4,9);
           }
        if (Model.curPlayer.score==6) {
            grid.add(img,5,9);
           }
        if (Model.curPlayer.score==7) {
            grid.add(img,6,9);
           }
        if (Model.curPlayer.score==8) {
            grid.add(img,7,9);
           }
        if (Model.curPlayer.score==9) {
            grid.add(img,8,9);
           }
        if (Model.curPlayer.score==10) {
            grid.add(img,9,9);
           }
        if (Model.curPlayer.score==11) {
            grid.add(img,9,8);
           }
       if (Model.curPlayer.score==12) {
            grid.add(img,8,8);
           }
       if (Model.curPlayer.score==13) {
            grid.add(img,7,8);
           }
       if (Model.curPlayer.score==14) {
            grid.add(img,6,8);
           }
       if (Model.curPlayer.score==15) {
            grid.add(img,5,8);
           }
       if (Model.curPlayer.score==16) {
            grid.add(img,4,8);
           }
       if (Model.curPlayer.score==17) {
            grid.add(img,3,8);
           }
       if (Model.curPlayer.score==18) {
            grid.add(img,2,8);
           }
       if (Model.curPlayer.score==19) {
            grid.add(img,1,8);
           }
       if (Model.curPlayer.score==20) {
            grid.add(img,0,8);
           }
       if (Model.curPlayer.score==21) {
            grid.add(img,0,7);
           }
       if (Model.curPlayer.score==22) {
            grid.add(img,1,7);
           }
       if (Model.curPlayer.score==23) {
            grid.add(img,2,7);
           }
       if (Model.curPlayer.score==24) {
            grid.add(img,3,7);
           }
       if (Model.curPlayer.score==25) {
            grid.add(img,4,7);
           }
       if (Model.curPlayer.score==26) {
            grid.add(img,5,7);
           }
       if (Model.curPlayer.score==27) {
            grid.add(img,6,7);
           }
       if (Model.curPlayer.score==28) {
            grid.add(img,7,7);
           }
       if (Model.curPlayer.score==29) {
            grid.add(img,8,7);
           }
       if (Model.curPlayer.score==30) {
            grid.add(img,9,7);
           }
       if (Model.curPlayer.score==31) {
            grid.add(img,9,6);
           }
       if (Model.curPlayer.score==32) {
            grid.add(img,8,6);
           }
       if (Model.curPlayer.score==33) {
            grid.add(img,7,6);
           }
       if (Model.curPlayer.score==34) {
            grid.add(img,6,6);
           }
       if (Model.curPlayer.score==35) {
            grid.add(img,5,6);
           }
       if (Model.curPlayer.score==36) {
            grid.add(img,4,6);
           }
       if (Model.curPlayer.score==37) {
            grid.add(img,3,6);
           }
       if (Model.curPlayer.score==38) {
            grid.add(img,2,6);
           }
       if (Model.curPlayer.score==39) {
            grid.add(img,1,6);
           }
       if (Model.curPlayer.score==40) {
            grid.add(img,0,6);
           }
       if (Model.curPlayer.score==41) {
            grid.add(img,0,5);
           }
       if (Model.curPlayer.score==42) {
            grid.add(img,1,5);
           }
       if (Model.curPlayer.score==43) {
            grid.add(img,2,5);
           }
       if (Model.curPlayer.score==44) {
            grid.add(img,3,5);
           }
       if (Model.curPlayer.score==45) {
            grid.add(img,4,5);
           }
       if (Model.curPlayer.score==46) {
            grid.add(img,5,5);
           }
       if (Model.curPlayer.score==47) {
            grid.add(img,6,5);
           }
       if (Model.curPlayer.score==48) {
            grid.add(img,7,5);
           }
       if (Model.curPlayer.score==49) {
            grid.add(img,8,5);
           }
       if (Model.curPlayer.score==50) {
            grid.add(img,9,5);
           }
       if (Model.curPlayer.score==51) {
            grid.add(img,9,4);
           }
       if (Model.curPlayer.score==52) {
            grid.add(img,8,4);
           }
       if (Model.curPlayer.score==53) {
            grid.add(img,7,4);
           }
       if (Model.curPlayer.score==54) {
            grid.add(img,6,4);
           }
       if (Model.curPlayer.score==55) {
            grid.add(img,5,4);
           }
       if (Model.curPlayer.score==56) {
            grid.add(img,4,4);
           }
       if (Model.curPlayer.score==57) {
            grid.add(img,3,4);
           }
       if (Model.curPlayer.score==58) {
            grid.add(img,2,4);
           }
       if (Model.curPlayer.score==59) {
            grid.add(img,1,4);
           }
       if (Model.curPlayer.score==60) {
            grid.add(img,0,4);
           }
       if (Model.curPlayer.score==61) {
            grid.add(img,0,3);
           }
       if (Model.curPlayer.score==62) {
            grid.add(img,1,3);
           }
       if (Model.curPlayer.score==63) {
            grid.add(img,2,3);
           }
       if (Model.curPlayer.score==64) {
            grid.add(img,3,3);
           }
       if (Model.curPlayer.score==65) {
            grid.add(img,4,3);
           }
       if (Model.curPlayer.score==66) {
            grid.add(img,5,3);
           }
       if (Model.curPlayer.score==67) {
            grid.add(img,6,3);
           }
       if (Model.curPlayer.score==68) {
            grid.add(img,7,3);
           }
       if (Model.curPlayer.score==69) {
            grid.add(img,8,3);
           }
       if (Model.curPlayer.score==70) {
            grid.add(img,9,3);
           }
       if (Model.curPlayer.score==71) {
            grid.add(img,9,2);
           }
       if (Model.curPlayer.score==72) {
            grid.add(img,8,2);
           }
       if (Model.curPlayer.score==73) {
            grid.add(img,7,2);
           }
       if (Model.curPlayer.score==74) {
            grid.add(img,6,2);
           }
       if (Model.curPlayer.score==75) {
            grid.add(img,5,2);
           }
       if (Model.curPlayer.score==76) {
            grid.add(img,4,2);
           }
       if (Model.curPlayer.score==77) {
            grid.add(img,3,2);
           }
       if (Model.curPlayer.score==78) {
            grid.add(img,2,2);
           }
       if (Model.curPlayer.score==79) {
            grid.add(img,1,2);
           }
       if (Model.curPlayer.score==80) {
            grid.add(img,0,2);
           }
       if (Model.curPlayer.score==81) {
            grid.add(img,0,1);
           }
       if (Model.curPlayer.score==82) {
            grid.add(img,1,1);
           }
       if (Model.curPlayer.score==83) {
            grid.add(img,2,1);
           }
       if (Model.curPlayer.score==84) {
            grid.add(img,3,1);
           }
       if (Model.curPlayer.score==85) {
            grid.add(img,4,1);
           }
       if (Model.curPlayer.score==86) {
            grid.add(img,5,1);
           }
       if (Model.curPlayer.score==87) {
            grid.add(img,6,1);
           }
       if (Model.curPlayer.score==88) {
            grid.add(img,7,1);
           }
       if (Model.curPlayer.score==89) {
            grid.add(img,8,1);
           }
       if (Model.curPlayer.score==90) {
            grid.add(img,9,1);
           }
       if (Model.curPlayer.score==91) {
            grid.add(img,9,0);
           }
       if (Model.curPlayer.score==92) {
            grid.add(img,8,0);
           }
       if (Model.curPlayer.score==93) {
            grid.add(img,7,0);
           }
       if (Model.curPlayer.score==94) {
            grid.add(img,6,0);
           }
       if (Model.curPlayer.score==95) {
            grid.add(img,5,0);
           }
       if (Model.curPlayer.score==96) {
            grid.add(img,4,0);
           }
       if (Model.curPlayer.score==97) {
            grid.add(img,3,0);
           }
       if (Model.curPlayer.score==98) {
            grid.add(img,2,0);
           }
       if (Model.curPlayer.score==99) {
            grid.add(img,1,0);
           }
        if (Model.curPlayer.score+Model.dice<=100) {
            
       Sound.move.play();
        }
        else{
            Sound.buzzer.play();
        }
       
       //Model.curPlayer.score=100;
       bool=Model.positionChecker();
        if (bool==true) {
            System.out.println("true");
            TimeUnit.SECONDS.sleep(1);
            movePiece();
        }
       
       score1.setText(String.valueOf(Model.p1.score));
       score2.setText(String.valueOf(Model.p2.score));
       
       if (Model.curPlayer.score==100) {
            grid.add(img,0,0);
            win1.setVisible(true);
            win2.setVisible(true);
            if (Model.curPlayer==Model.p1) {
               win2.setText(Model.pn1);
           }else{
                win2.setText(Model.pn2);
            }
             Sound.win1.play();
             Sound.win2.play();
             TimeUnit.SECONDS.sleep(1);
             Sound.win3.play();
            move.setDisable(true);
            System.out.println("win");
       }
       else{
       dice.setVisible(true);
       move.setDisable(true);
       turnChanger();
       }
    }
    
    @FXML
    private void playerNames(){
        player1.setText("1");
        player2.setText("2");
    }
    
    @FXML
    private void mouseEnter1()
    { 
        dice.setScaleX(1.4);
        dice.setScaleZ(1.4);
        dice.setScaleY(1.4);
        roll.setText("Roll Dice !");
        
    }
    
    @FXML
    private void mouseExit1()
    {
        dice.setScaleX(1);
        dice.setScaleZ(1);
        dice.setScaleY(1);
        roll.setText("");
        
    }
    
    @FXML
    private void mouseEnter2()
    {
        Sound.hover.play();
        back.setScaleX(1.4);
        back.setScaleZ(1.4);
        back.setScaleY(1.4);
        
    }
    
    @FXML
    private void mouseExit2()
    {
        back.setScaleX(1);
        back.setScaleZ(1);
        back.setScaleY(1);
        
    }
    @FXML
    private void mouseEnter3()
    {
        
       fade(start);
        
    }
    
    @FXML
    private void mouseEnterLv1()
    {
        Sound.hover.play();
        lv1.setScaleX(1.6);
        lv1.setScaleZ(1.6);
        lv1.setScaleY(1.6);
        lvl1.setVisible(true);
        lv1.setOpacity(0.9);
        
    }
    @FXML
    private void mouseExitLv1()
    {
        lv1.setScaleX(1.0);
        lv1.setScaleZ(1.0);
        lv1.setScaleY(1.0);
        lvl1.setVisible(false);
        lv1.setOpacity(0.5);
    }
    @FXML
    private void mouseEnterLv2()
    {
        Sound.hover.play();
        lv2.setScaleX(1.6);
        lv2.setScaleZ(1.6);
        lv2.setScaleY(1.6);
        lvl2.setVisible(true);
        lv2.setOpacity(0.9);
        
    }
    @FXML
    private void mouseExitLv2()
    {
        
        lv2.setScaleX(1.0);
        lv2.setScaleZ(1.0);
        lv2.setScaleY(1.0);
        lvl2.setVisible(false);
        lv2.setOpacity(0.5);
    }
    @FXML
    private void mouseEnterLv3()
    {
        Sound.hover.play();
        lv3.setScaleX(1.6);
        lv3.setScaleZ(1.6);
        lv3.setScaleY(1.6);
        lvl3.setVisible(true);
        lv3.setOpacity(0.9);
        
    }
    @FXML
    private void mouseExitLv3()
    {
        lv3.setScaleX(1.0);
        lv3.setScaleZ(1.0);
        lv3.setScaleY(1.0);
        lvl3.setVisible(false);
        lv3.setOpacity(0.5);
    }
    
    @FXML
    private void turnChanger(){
        if (Model.curPlayer==Model.p1 && Model.dice<6) {
            
                Model.curPlayer=Model.p2;
                turn.setLayoutX(615);
                turn.setLayoutY(478);
            }
            else
            { if (Model.curPlayer==Model.p2 && Model.dice<6){
                Model.curPlayer=Model.p1;
              turn.setLayoutX(615);
              turn.setLayoutY(390);
            }
            }
        
    }
    
   
    
    
    static void fade(ImageView x)
        {FadeTransition ft = new FadeTransition(Duration.millis(1000), x);
        
          ft.setFromValue(1.0);
          ft.setToValue(0.1);
          ft.setCycleCount(Timeline.INDEFINITE);
          ft.setAutoReverse(true);
          ft.play();
        }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    
}
