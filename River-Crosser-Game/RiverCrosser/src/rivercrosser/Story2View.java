/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class Story2View {
     private Stage Window;
    public void setStage(Stage window)
    {
        Window=window;
    }
    public Story2Controller display() 
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Story2.fxml"));
        Pane root;
        try {
            root = loader.load();
            Window.setScene(new Scene(root,600,400));
            Window.show();
        } catch (IOException ex) {
            Logger.getLogger(Story1View.class.getName()).log(Level.SEVERE, null, ex);
        }
        Story2Controller controller=loader.getController();
        System.out.println("Cont="+controller);
        
        return controller;
        
    }
}
