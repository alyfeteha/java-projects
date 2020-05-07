/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitnigga;

import java.io.File;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author Lenovo
 */     
public class TacticalNuke extends Bomb {
    Node Appearance = new Circle(50, new ImagePattern(new Image(getClass().getResourceAsStream("/Images/ManNuke.png"))));
    boolean incoming= false;
    int counter=0;
    Timeline timeline;
    String musicFile ="Nuke.mp3" ;
    Media sound = new Media(new File(musicFile).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);
    public TacticalNuke() {
        super();
        super.Appearance = Appearance;
        
    }   
        
    public void setAppearance() {
        
        incoming = true;
        //ImagePattern cut = new ImagePattern(new Image(getClass().getResourceAsStream("/Images/cutPassiom.png")));
        super.Appearance.setVisible(false);
        mediaPlayer.play();
        
       
        //((Circle) super.Appearance).setFill(cut);
        
    }   
}       