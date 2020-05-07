/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitnigga;

import javafx.animation.PathTransition;
import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Eco
 */
public class Fruit extends GameObject{
    
    PathTransition t;
    private int Score;
    public Fruit()
    {
        super();

    }
    public void setAppearance()
    {}
   public Fruit setAppearancecut()
   {return this;}

    /**
     * @return the Score
     */
    public int getScore() {
        return Score;
    }

    /**
     * @param Score the Score to set
     */
    public void setScore(int Score) {
        this.Score = Score;
    }
}
 
