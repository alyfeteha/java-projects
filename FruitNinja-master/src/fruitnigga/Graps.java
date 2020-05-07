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
public class Graps extends Normal{
      Node Appearance = new Circle(40,new ImagePattern(new Image(getClass().getResourceAsStream("/Images/Grapes.png"))));
   
            
    public Graps() {
        super();
        super.Appearance=Appearance;
        
    }
    public Graps setAppearancecut() {

        ImagePattern cut= new ImagePattern(new Image(getClass().getResourceAsStream("/Images/cutGraps.png")));
        ImagePattern cut2= new ImagePattern(new Image(getClass().getResourceAsStream("/Images/cutGraps2.png")));
        play();
        ((Circle)super.Appearance).setFill(cut);
        Graps neww=new Graps();
        neww.Appearance.setTranslateY(this.Appearance.getTranslateY());
        ((Circle)neww.Appearance).setFill(cut2);
        neww.Appearance.setTranslateX(neww.Appearance.getTranslateX()+50);
        return neww;

    }
}
