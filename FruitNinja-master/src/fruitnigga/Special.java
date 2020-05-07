/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitnigga;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 *
 * @author Lenovo
 */
public class Special extends Fruit{
    String musicFile ="Hallelujah.mp3" ;
    Media sound = new Media(new File(musicFile).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);

    void play()
    {
        mediaPlayer.play();
    }
}
