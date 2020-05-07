/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitnigga;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 *
 * @author Lenovo
 */
public class Watermelon extends Normal{
    Node Appearance = new Circle(40,new ImagePattern(new Image(getClass().getResourceAsStream("/Images/Watermelon.png"))));
   
            
    public Watermelon() {
        super();
        super.Appearance=Appearance;
        
    }
    public Watermelon setAppearancecut() {

        ImagePattern cut= new ImagePattern(new Image(getClass().getResourceAsStream("/Images/Watermeloncut.png")));
        ImagePattern cut2= new ImagePattern(new Image(getClass().getResourceAsStream("/Images/Watermeloncut2.png")));
        play();
        ((Circle)super.Appearance).setFill(cut);
        Watermelon neww=new Watermelon();
        neww.Appearance.setTranslateY(this.Appearance.getTranslateY());
        ((Circle)neww.Appearance).setFill(cut2);
        neww.Appearance.setTranslateX(neww.Appearance.getTranslateX()+50);
        return neww;

    }

    
}
