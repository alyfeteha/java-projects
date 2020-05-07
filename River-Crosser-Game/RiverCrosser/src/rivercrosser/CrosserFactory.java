/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author Lenovo
 */
public class CrosserFactory {
    
    
    
    public Crosser createCrosser(String Type,int id)
    {
     if(Type.equalsIgnoreCase("farmer"))
     {
        switch(id)
        {
           case(0):
                   {
                      return new Farmer(new Rectangle(40,40,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/crew (4).png")))), 90, "feteha");
                   }
           case(1):
                   {
                      return new Farmer(new Rectangle(40,40,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/crew (4).png")))), 80, "khella");
                   }
           case(2):
                   {
                      return new Farmer(new Rectangle(40,40,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/crew (4).png")))), 60, "ossa");
                   }
           case(3):
                   {
                      return new Farmer(new Rectangle(40,40,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/crew (4).png")))), 40, "salooha");
                   }
        }        
     }
     else if(Type.equalsIgnoreCase("carnivore"))
     {
          switch(id)
        {
           case(0):
                   {
                      return new Carnivore(new Circle(30,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/walrus.png")))), 90, "feteha");
                   }
           case(1):
                   {
                      return new Carnivore(new Rectangle(35,41,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/dog.png")))), 90, "feteha");
                   }
          
        }        
     }
     else if(Type.equalsIgnoreCase("herbivore"))
     {
          switch(id)
        {
           case(0):
                   {
                      return new Herbivore(new Rectangle(45,34,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/panda.png")))), 90, "feteha");
                   }
           case(1):
                   {
                      return new Herbivore(new Rectangle(34,37,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/zebra.png")))), 90, "feteha");
                   }
           case(2):
                   {
                      return new Herbivore(new Rectangle(35,41,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/chicken.png")))), 90, "feteha");
                   }
          
        }      
     }
     else if(Type.equalsIgnoreCase("plant"))
     {
          switch(id)
        {
           case(0):
                   {
                      return new Plant(new Rectangle(45,34,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/warda.png")))), 90, "feteha");
                   }
           case(1):
                   {
                      return new Plant(new Rectangle(33,40,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/warda1.png")))), 90, "feteha");
                   }
        }      
     }
     else 
     {
         System.out.println("Factory doesn't have this product");
     }
        return null;
     
    }
    
}
