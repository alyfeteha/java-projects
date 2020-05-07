package fruitnigga;

import javafx.animation.PathTransition;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

import static java.lang.invoke.MethodHandles.loop;

public class View {
    Controller control;
    Stage window = new Stage();
    Pane root = new Pane();
    private ArrayList<Fruit> Spawned = new ArrayList<Fruit>();
    PathTransition spawn;

    void setController(Controller controller)
    {
        control=controller;
    }
    void start(Stage primaryStage)
    {
        root.setPrefSize(600, 600);
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }

    public void setSpawned(ArrayList<Fruit> spawned) {
        Spawned=spawned;
    }

    public Fruit AddFruits(double x,double y,Fruit fruit)
    {

        Polyline path = new Polyline();
        path.getPoints().addAll(new Double[]{
                x,600.0,
                x, y,
                x, 2000.0 });
        spawn = new PathTransition();
        spawn.setNode(fruit.Appearance);
        spawn.setDuration(Duration.seconds(5));
        spawn.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        spawn.setPath(path);

        root.getChildren().add(fruit.Appearance);
        spawn.play();
        return fruit;


    }
    public void checkMouse()
    {
        for(Fruit f:Spawned)
        {
            f.Appearance.setOnMouseEntered(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent e) {

                    f.setAppearance();
                }


            });
        }
    }

}
