package fruitnigga;

import javafx.animation.Timeline;

import java.util.ArrayList;
import java.util.Random;

public class Model {
    Controller control;
    private ArrayList<GameObject> Spawned = new ArrayList<>();
    private ArrayList<GameObject> Sliced = new ArrayList<>();                   //khalil
    private Factory factory=new Factory();
    int lives =3;
    int score=0;
    int lastupdate=60;
    void updateForArcade()
    {
        if(control.getArcadeTime().getSecondsPassed()%20==0)
        {
            if(control.getArcadeTime().getSecondsPassed()!=lastupdate)
            {
            reduceLives();
            lastupdate=control.getArcadeTime().getSecondsPassed();
            
            }
        }
    }
    public void resetUpdate()
    {
        lastupdate=60;
    }
    void reduceLives()                                                          //khalil
    {
        lives--;
    }
    int getLives()                                                              //khalil
    {
        return lives;
    }
     void spawnedRemovesliceAdd(GameObject o)
   {
       Spawned.remove(o);
       Sliced.add(o);
   }
    void updateLivesOnSlice(GameObject objectSliced)                            //khalil
    {
        if(objectSliced instanceof  Kaboom&&!(control.getLevel().getFrequency()==0.03))
        {

            reduceLives();
            System.out.println("LIVES = "+getLives());
        }
        else if(objectSliced instanceof TacticalNuke)
        {
            lives=0;
        }
        
    }
    void updatelivesOnFallen(GameObject objectFallen)                           //khalil
    {
        
        if(objectFallen instanceof Fruit)
        {
            if(Spawned.contains(objectFallen))
            {
                
                
                
                Spawned.remove(objectFallen);
                reduceLives();
                System.out.println("LIVES = "+getLives());
            }
            
        }
    }
    GameObject getFallenobject()                                                //khalil
    {
        int i;
        if(control.isNuked()==false)
        {
            for(i=0;i<Spawned.size();i++)
            {
            
                if(Spawned.get(i).Appearance.getTranslateY()<1800.0&&Spawned.get(i).Appearance.getTranslateY()>700)
                {
                    GameObject objectFallen=Spawned.get(i);
                    if(Spawned.get(i) instanceof Bomb)
                    Spawned.remove(Spawned.get(i));
                    return objectFallen;
                }
            
            
             }
        }
        return new Kaboom();
    }
    boolean checkEnd()                                                          //khalil
    {
        if(lives<=0)
        {
            


            return true;
        }
        else
            return false;
    }



    public int updateScore(int value)
    {
        System.out.println("scorebefore "+score);
        if(score+value<0)
            score=0;
        else
        score+=value;
        System.out.println("scoreafter "+score);
        System.out.println("Value "+value);

        return score;

    }

    void setController(Controller controller)
    {
        control=controller;
    }

    public void handle(double difficulty) {
        GameObject fruit= new TacticalNuke();
        Random rand = new Random();
        Double y,z= ((double)rand.nextInt(600));
        while(z>300||z<40)
        {
            z= ((double)rand.nextInt(600));
        }
        if (Math.random() < difficulty) {
           if(control.getLevel().getFrequency()==0.03)
            y=(double)rand.nextInt(26); 
           else
            y=(double)rand.nextInt(27);

            fruit=factory.createGameObject(y);



            control.addFruitstoView(((double)rand.nextInt(600)), z, fruit);

        }

    }

    void addFruit(GameObject fruit)
    {

        Spawned.add(fruit);
    }
    public ArrayList<GameObject> getSpawned() {
        return Spawned;
    }

    //khalil
    public ArrayList<GameObject> getSliced() {
        return Sliced;
    }
    public int getScore()
    {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void Empty()
    {
        Spawned.removeAll(Spawned);
        Sliced.removeAll(Sliced);
    }
}
