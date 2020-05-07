/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitnigga;
 import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
/**
 *
 * @author Lenovo
 */
public class Factory {
   



    public GameObject createGameObject(double ProductNumber)
    {
        if(ProductNumber<=5)
                return new Orange();
            else if(ProductNumber<=10)
                return new Graps();
            else if(ProductNumber<=15)
                return new Watermelon();
            else if(ProductNumber<=20)
                return new Pineapple();
            else if(ProductNumber>22&&ProductNumber<25) {
                return new Kaboom();
                //System.out.println("kombela");
            }
            else if(ProductNumber==21)
                return new Banana();
            else if (ProductNumber==22)
                return new Passiom();

             else if (ProductNumber==26) {
                return new TacticalNuke();
                //System.out.println("incoming");
            }
             else
             return new Watermelon();
        



    }
}
