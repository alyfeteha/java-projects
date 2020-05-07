/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class Story1View 
    {
    
    private Stage Window;
    private CrosserFactory Generator= new CrosserFactory();
    Pane root;
    private ArrayList<Crosser> Crosssers= new  ArrayList<>();
    private Boat boat;
    private Node Harbour1;
    private Node Harbour2;
    private Node Border1;
    private Node Border2;
    
    public void setStage(Stage window)
    {
        Window=window;
    }
    public Story1Controller display() 
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Story1.fxml"));
        
        try {
            root = loader.load();
            Window.setScene(new Scene(root));
            Window.show();
        } catch (IOException ex) {
            Logger.getLogger(Story1View.class.getName()).log(Level.SEVERE, null, ex);
        }
        Setup();
        Story1Controller controller=loader.getController();
        System.out.println("Cont="+controller);
        
        return controller;
        
    }

    private void addCrosser(Crosser crosser,double x,double y)
    {
        
        crosser.getAppearance().setTranslateX(x);
        crosser.getAppearance().setTranslateY(y);
        Crosssers.add(crosser);     
        root.getChildren().add(crosser.getAppearance());
        //BorderPane border=(BorderPane) root.getChildren().get(2);
       // border.getChildren().add(crosser.getAppearance());
        
    }
    private void Setup()
    {
        addHarbour();
        addBoat();
        addCrosser(Generator.createCrosser("Farmer",3),100,100); 
        addCrosser(Generator.createCrosser("Herbivore",2),200,100); 
        addCrosser(Generator.createCrosser("Carnivore",1),300,100); 
        addCrosser(Generator.createCrosser("Plant",0),400,100); 
           
    }
    private void addBoat()
    {
        boat = new Boat();
        boat.Appearance.setTranslateX(445);
        boat.Appearance.setTranslateY(220);
        root.getChildren().add(boat.Appearance);
    }
    public void addHarbour()
    {
        Harbour2=new Rectangle(40,40,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/zebra.png"))));
        Harbour1= new Rectangle(40,40,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/assets/zebra.png"))));
        Border1 = new Rectangle(515,5,javafx.scene.paint.Color.RED);
        Border2 = new Rectangle(515,5,javafx.scene.paint.Color.RED);
        Border1.setTranslateX(50);
        Border1.setTranslateY(210);
        Border2.setTranslateX(50);
        Border2.setTranslateY(430);
        Harbour1.setTranslateX(90);
        Harbour1.setTranslateY(425);
        Harbour2.setTranslateX(480);
        Harbour2.setTranslateY(190);
        root.getChildren().add(Harbour1);
        root.getChildren().add(Harbour2);
        root.getChildren().add(Border1);
        root.getChildren().add(Border2);
        
    }   
    public ArrayList getCrossers()
    {
      return this.Crosssers;  
    }
    public Boat getBoat()
    {
        return this.boat;
    }
    public Node getBorder1()
    {
     return this.Border1;   
    }
     public Node getBorder2()
    {
     return this.Border2;   
    }
    public Stage getStage()
    {
      return this.Window;  
    }
    public Pane getRoot()
    {
        return this.root;
    }
    public Node getHarbour1()
            
    {
        return Harbour1;
    }
    public Node getHarbour2()
            
    {
        return Harbour2;
    }
     
}
