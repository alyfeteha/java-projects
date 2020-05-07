/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitnigga;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.File;

/**
 *
 * @author Lenovo
 */
public class Kaboom extends Bomb {
    Node Appearance = new Circle(70, new ImagePattern(new Image(getClass().getResourceAsStream("/Images/Kapom.png"))));

    String musicFile ="smolexblosion.mp3" ;
    Media sound = new Media(new File(musicFile).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);


    public Kaboom() {
        super();
        super.Appearance = Appearance;

    }

    public void setAppearance() {
        ImagePattern cut = new ImagePattern(new Image(getClass().getResourceAsStream("/Images/finish.png")));

        ((Circle) super.Appearance).setFill(cut);
        mediaPlayer.play();

    }
}
