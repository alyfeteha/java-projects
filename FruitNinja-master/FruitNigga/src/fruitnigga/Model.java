package fruitnigga;

import javafx.animation.PathTransition;

import java.util.ArrayList;
import java.util.Random;

public class Model {
    Controller control;
    private ArrayList<Fruit> Spawned = new ArrayList<Fruit>();
    Fruit fruit;



    void setController(Controller controller)
    {
        control=controller;
    }

    public void handle() {
        Random rand = new Random();
        Double y= ((double)rand.nextInt(600));
        while(y>400)
        {
            y= ((double)rand.nextInt(600));
        }
        if (Math.random() < 0.02) {
            fruit = new Orange();
            control.addFruitstoView(((double)rand.nextInt(600)), y, fruit);

        }

    }

    void addFruit(Fruit fruit)
    {

        Spawned.add(fruit);
    }
    public ArrayList<Fruit> getSpawned() {
        return Spawned;
    }
}
