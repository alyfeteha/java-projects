/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class Boat extends GameObject{
   int Passengers=0;
   boolean drivable;
    public Boat()
    {
        this.Appearance = new Rectangle(30,30,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/boat.png"))));
    }
   
    public Node getBoat()
    {
        return Appearance;
    }
    public boolean isDrivable()
    {
        return drivable;
    }
    
     public void moveUp()
    {
        Appearance.setTranslateY(Appearance.getTranslateY()-15);
        Appearance.setRotate(-180);
    }
    public void moveDown()
    {
        Appearance.setTranslateY(Appearance.getTranslateY()+15);
        Appearance.setRotate(-180);
    }
    public void moveLeft()
    {
        Appearance.setTranslateX(Appearance.getTranslateX()-15);
         Appearance.setRotate(90);
    }
    public void moveRight()
    {
        Appearance.setTranslateX(Appearance.getTranslateX()+15);
         Appearance.setRotate(-90);
    }
    public boolean atHarbour(Node harbour)
    {
        
        return Appearance.getBoundsInParent().intersects(harbour.getBoundsInParent());
    }
   //public Boat getBoat()
   //{
       //return new Boat(new Rectangle(30,30,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/crew (4).png")))), 90, "feteha");
   //}
}
