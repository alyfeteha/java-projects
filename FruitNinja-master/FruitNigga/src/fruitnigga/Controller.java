package fruitnigga;

import javafx.animation.AnimationTimer;
import javafx.stage.Stage;

import java.util.Random;

public class Controller {
    View view=new View();
    Model model=new Model();



   void start(Stage primaryStage)
   {
       view.setController(this);
       model.setController(this);
       view.start(primaryStage);
       view.setSpawned(model.getSpawned());
       loop();
   }


    private void loop()
    {
        AnimationTimer timer;


        timer = new AnimationTimer() {
            //  @Override

            //@Override
            public void handle(long l) {
                model.handle();
            }



        };
        timer.start();
    }


    public void addFruitstoView(Double x, Double y, Fruit fruit) {
       model.addFruit(view.AddFruits(x,y,fruit));
        view.checkMouse();
    }
}
