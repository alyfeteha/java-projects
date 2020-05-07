package fruitnigga;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;
import javafx.scene.input.MouseEvent;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.util.Duration;

public class Controller {
    private static Controller singleton= null;
    View view=new View();
    Model model=new Model();
    
    AnimationTimer timer;                                                       //khalil2


    private Controller(){};    
    //khalil2
    public ArcadeTime getArcadeTime()
    {
        return view.getArcadeTime();
    }
    public Level getLevel()
    {
        return view.getLevel();
    }
      public void emptyAll()
  {model.Empty();}
      public void resetScore()
    {
        model.setScore(0);
    }
    public static Controller getInstance()                                      //khalil2
    {
        if(singleton==null)
        {
            singleton=new Controller();
        }
        
        return singleton;
    }

   void start(Stage primaryStage)
   {
       //salah


       try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("Main2.fxml"));
           Pane root =  loader.load();

       //System.out.println(view+"+"+loader);
       // loader.setController(view);
       System.out.println(view+"+"+loader.getController());
       view = loader.getController();
       System.out.println(view+"+"+loader.getController());

       view.setController(this);
       model.setController(this);
       view.start(primaryStage,loader,root);//salah
       view.setArrayLists(model.getSpawned(),model.getSliced());
       } catch (IOException e) {
           e.printStackTrace();
       }
       //salah
   }
   




    public void loop()
    {
        
       

        timer = new AnimationTimer() {
            //  @Override

            //@Override
            public void handle(long l) {
                model.handle(view.getLevel().getFrequency());
                if(view.getLevel().getFrequency()==0.03)
                {
                    model.updateForArcade();
                    updateArcade();
                }
                else
                {
                    updateLivesOnFallen();
                }
                view.mouseExited();
                view.livesSet(model.getLives());
                view.setTimeLabel();
                
               // view.checkCut();
            }
            
           


        };
        timer.start();
    }



    void spawnedRemovesliceAdd(GameObject o)                                             //khalil
    {
        model.spawnedRemovesliceAdd(o);
    }

    void updateLivesOnSlice(GameObject sliced)                                   //khalil
    {
        model.updateLivesOnSlice(sliced);
        if(model.checkEnd())                                                     //khalil2
        {
            stopGame();
        }
    }
    void updateArcade()
    {
        if(model.checkEnd())
            stopGame();
    
    }

    void updateLivesOnFallen()                                                   //khalil
    {
        model.updatelivesOnFallen(model.getFallenobject());
        if(model.checkEnd())                                                    //khalil2
        {
            stopGame();
            
        }
    }


    public void addFruitstoView(Double x, Double y, GameObject fruit) {
       model.addFruit(view.AddFruits(x,y,fruit));
        view.checkMouse();
    }


    public int updateScore(int value)
    {

        return model.updateScore(value);
    }
    public int getScore()
    {
        return model.getScore();
    }
    public void stopGame()                                                      //khalil2
    {
        
        view.livesSet(model.getLives());
        timer.stop();
        view.endGame();
        //save
         model.lives=3;
        model.score=0;
        model.resetUpdate();
        //AlertBox.display("Loser", "");
    }
  public boolean isNuked()
  {
      return view.Nuked;
  }
}
