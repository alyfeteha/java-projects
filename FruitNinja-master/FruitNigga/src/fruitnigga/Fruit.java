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
public class Fruit {
    Node Appearance;
    PathTransition t;
    public Fruit()
    {
        this.Appearance=Appearance;

    }

    public void setAppearance() {
        ImagePattern cut= new ImagePattern(new Image(getClass().getResourceAsStream("/Images/cutOrange.png")));
        ((Circle)this.Appearance).setFill(cut);
    }
}
 class Orange extends Fruit{
    Node Appearance = new Circle(40,new ImagePattern(new Image(getClass().getResourceAsStream("/Images/Orange.png"))));
   
            
    public Orange() {
        super();
        super.Appearance=Appearance;
        
    }


 }
