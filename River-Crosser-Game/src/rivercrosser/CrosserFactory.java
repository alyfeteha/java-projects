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
                      return new Farmer(new Rectangle(30,30,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/crew (4).png")))), 90, "feteha",new Boolean(true),5);
                   }
           case(1):
                   {
                      return new Farmer(new Rectangle(40,40,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/crew (4).png")))), 80, "khella",new Boolean(true),5);
                   }
           case(2):
                   {
                      return new Farmer(new Rectangle(40,40,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/crew (4).png")))), 60, "ossa",new Boolean(true),5);
                   }
           case(3):
                   {
                      return new Farmer(new Rectangle(40,40,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/crew (4).png")))), 40, "salooha",new Boolean(true),5);
                   }
        }        
     }
     else if(Type.equalsIgnoreCase("carnivore"))
     {
          switch(id)
        {
           case(0):
                   {
                      return new Carnivore(new Circle(20,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/walrus.png")))), 90, "feteha",new Boolean(false),3);
                   }
           case(1):
                   {
                      return new Carnivore(new Rectangle(25,41,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/dog.png")))), 30, "feteha",new Boolean(false),3);
                   }
          
        }        
     }
     else if(Type.equalsIgnoreCase("herbivore"))
     {
          switch(id)
        {
           case(0):
                   {
                      return new Herbivore(new Rectangle(25,24,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/panda.png")))), 85, "feteha",new Boolean(false),2);
                   }
           case(1):
                   {
                      return new Herbivore(new Rectangle(34,37,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/zebra.png")))), 70, "feteha",new Boolean(false),2);
                   }
           case(2):
                   {
                      return new Herbivore(new Rectangle(35,41,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/chicken.png")))), 5, "feteha",new Boolean(false),2);
                   }
          
        }      
     }
     else if(Type.equalsIgnoreCase("plant"))
     {
          switch(id)
        {
           case(0):
                   {
                      return new Plant(new Rectangle(25,24,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/warda.png")))), 10, "feteha",new Boolean(false),1);
                   }
           case(1):
                   {
                      return new Plant(new Rectangle(33,40,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/warda1.png")))), 10, "feteha",new Boolean(false),1);
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
