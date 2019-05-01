/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author hk_th
 */
public class Sound {
    private Clip clip;

    
    // Change file name to match yours, of course
    public static Sound intro = new Sound("/sounds/intro.wav");
    public static Sound level1 = new Sound("/sounds/Level 1.wav");
    public static Sound level2 = new Sound("/sounds/Level 2.wav");
    public static Sound level3 = new Sound("/sounds/Level 3.wav");
    public static Sound ufo = new Sound("/sounds/ufo.wav");
    public static Sound rocket = new Sound("/sounds/rocket.wav");
    public static Sound snake = new Sound("/sounds/snake.wav");
    public static Sound ladder = new Sound("/sounds/ladder.wav");
    public static Sound move = new Sound("/sounds/move.wav");
    public static Sound buzzer = new Sound("/sounds/buzzer.wav");
    public static Sound win1 = new Sound("/sounds/win1.wav");
    public static Sound win2 = new Sound("/sounds/win2.wav");
    public static Sound win3 = new Sound("/sounds/win3.wav");
    public static Sound hover = new Sound("/sounds/hover.wav");
    public static Sound diceroll = new Sound("/sounds/dice roll.wav");
    public static Sound click = new Sound("/sounds/click.wav");
    

     

   public Sound (String fileName) {

        try {

            AudioInputStream ais = AudioSystem.getAudioInputStream(Sound.class.getResource(fileName));

            clip = AudioSystem.getClip();

            clip.open(ais);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

 

    public void play() {

        try {

            if (clip != null) {

                new Thread() {

                    public void run() {

                        synchronized (clip) {

                            clip.stop();

                            clip.setFramePosition(0);

                            clip.start();

                        }

                    }

                }.start();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

     

    public void stop(){

        if(clip == null) return;

        clip.stop();

    }

     

    public void loop() {

        try {

            if (clip != null) {

                new Thread() {

                    public void run() {

                        synchronized (clip) {

                            clip.stop();

                            clip.setFramePosition(0);

                            clip.loop(Clip.LOOP_CONTINUOUSLY);

                        }

                    }

                }.start();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

     

    public boolean isActive(){

        return clip.isActive();

    
    
}
}
