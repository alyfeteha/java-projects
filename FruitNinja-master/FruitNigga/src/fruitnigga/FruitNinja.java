/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitnigga;

//import com.sun.java.swing.plaf.windows.resources.windows;
import static java.awt.SystemColor.window;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Eco
 */
public class FruitNinja extends Application{

    //Stage window = new Stage();
    //Pane root = new Pane();

     //private ArrayList<Fruit> Spawned = new ArrayList<Fruit>();
    public void start(Stage primaryStage) throws IOException {
        Controller control= new Controller();
        control.start(primaryStage);
    }


     public static void main(String[] args) {
        launch(args);
    }

}
