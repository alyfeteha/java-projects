package fruitnigga;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.shape.Line;





public class View implements Initializable{
    Controller control;
    Stage window = new Stage();
    Pane root; //salah
    boolean Nuked=false;
    XML_Read read=new XML_Read();
    XML_Actions write=new XML_Actions();
    int highChild=Integer.parseInt(read.ReadXMLFile("C:\\Users\\SalahAbdou\\IdeaProjects\\FruitNigga\\src\\child.xml"));
    int highMed=Integer.parseInt(read.ReadXMLFile("C:\\Users\\SalahAbdou\\IdeaProjects\\FruitNigga\\src\\amature.xml"));
    int highPro=Integer.parseInt(read.ReadXMLFile("C:\\Users\\SalahAbdou\\IdeaProjects\\FruitNigga\\src\\pro.xml"));
    int highArc=Integer.parseInt(read.ReadXMLFile("C:\\Users\\SalahAbdou\\IdeaProjects\\FruitNigga\\src\\arcade.xml"));
    int counter;
    private Time Elapsed=new Time();
    private ArcadeTime Remaining=new ArcadeTime();
    
    Timeline timeline=new Timeline();
    Timeline Timer= new Timeline();
    int reach1=0;
    int reach2=0;
    int score;
    double opac;

    public ImageView bg;//salah
    private ArrayList<GameObject> Spawned = new ArrayList<>();
    PathTransition spawn;
    private ArrayList<GameObject> Sliced = new ArrayList<>();                    //khalil
    Scene scene;//khalil
    public Button endman;
    public Label Score,scoreLabel,Lives,highC,highM,highP,highA,scorePlus;
    public ImageView life1,life2,life3,tool;
    Image knife = new Image("/images/Knife.png");                               //khalil
    Image cutknife = new Image("/images/CutKnife.png");
    Image end=new Image("/Images/End.png");     
    ImageView imageView=new ImageView(end);
    public Label nuketimer;
    public Label timeLabel;
    
    Level level;
    public ArcadeTime getArcadeTime()
    {
        return Remaining;
    }
    
    public void setTimeLabel()
    {
        if(level.getFrequency()==0.03)
        {
            timeLabel.setText("Time:"+Remaining.getSecondsPassed()+":"+Remaining.getMilli());
        }
        else
        timeLabel.setText("Time:"+Elapsed.getSecondsPassed()+":"+Elapsed.getMilli());
    }
    

    public void endGame()
    {
         for(GameObject f:Spawned)
        {
            root.getChildren().remove(f.Appearance);
        }
        for(GameObject f:Sliced)
        {
            root.getChildren().remove(f.Appearance);
        }
        control.emptyAll();
       
        System.out.println("pro"+highMed+"   "+"arcade"+highArc);
        Elapsed.stop();
        Remaining.stop();
        
    
        if(level.getFrequency()==0.01)
        {
           if(score>highChild)
           {
           highChild= score;
           write.writeXML(String.valueOf(score),"C:\\Users\\SalahAbdou\\IdeaProjects\\FruitNigga\\src\\child.xml" );
           
           }
           highC.setText("Highscore: "+highChild);
        }
        else if(level.getFrequency()==0.04)
        {
                if(score>highMed)
                {
                highMed= score;
                write.writeXML(String.valueOf(score),"C:\\Users\\SalahAbdou\\IdeaProjects\\FruitNigga\\src\\amature.xml" );
                }
                highM.setText("Highscore: "+highMed);
        }
        else if(level.getFrequency()==0.06)
        {       if(score>highPro)
        {
                highPro= score;
                write.writeXML(String.valueOf(score),"C:\\Users\\SalahAbdou\\IdeaProjects\\FruitNigga\\src\\pro.xml" );
        }
        highP.setText("Highscore: "+highPro);
        }
        else if(level.getFrequency()==0.03)
        {       if(score>highArc)
        {
            highArc= score;
            write.writeXML(String.valueOf(score),"C:\\Users\\SalahAbdou\\IdeaProjects\\FruitNigga\\src\\arcade.xml" );
        }
            highA.setText("Highscore: "+highArc);
        }
        imageView.setTranslateY(35);
        imageView.setFitHeight(600-35);
        imageView.setFitWidth(600);
        
        endman.setVisible(true);
        
        //imageView.se
        root.getChildren().add(imageView);
        endman.toFront();
        
        
    }
    public void toMenu()
    {
        reach2=0;
        control.resetScore();
       
        
        Elapsed=new Time();
        Remaining=new ArcadeTime();
        Elapsed.setMilli(0);
        Elapsed.setSecondsPassed(0);
        Score.setText("0");
        root.getChildren().remove(imageView);
        int i=0;
        while(i!=root.getChildren().size()) {
            if(root.getChildren().get(i) instanceof Button ||root.getChildren().get(i) instanceof Label)
                root.getChildren().get(i).setVisible(true);
            if(root.getChildren().get(i) instanceof ImageView)
                root.getChildren().get(i).setVisible(false);
            i++;
        }
        bg.setVisible(true);
        scoreLabel.setVisible(false);
        Score.setVisible(false);
        Lives.setVisible(false);
        scorePlus.setVisible(false);
        bg.setOpacity(0.6);
        endman.setVisible(false);
        nuketimer.setVisible(false);
        timeLabel.setVisible(false);
        //root.getChildren().remove(timer);
        revive();
        
    }
    void setController(Controller controller)
    {
        control=controller;
        System.out.println("this: " + this);
    }
    void start(Stage primaryStage,FXMLLoader loader ,Pane root1)//salah
    {
        //salah
        root=root1;

        root.setPrefSize(600,600);
        //salah
        scene =new Scene(root);                                                 //khalil
        primaryStage.setScene(scene);


        primaryStage.show();
        //salah

    }

    public void setSpawned(ArrayList<GameObject> spawned) {
        Spawned=spawned;
    }
    //salah
    public void Level1()
    {
        
        level=new ChildsPlay();
        setLevel();
        System.out.println("levelhi="+level);
        
    }
    public void Amateur()
    {
        
        level=new Amateur();
        setLevel();
    }
    public void Pro()
    {
        
        level=new Pro();
        setLevel();
    }
    public void Arcade()
    {
        
        level=new Arcade();
        setLevel();
    }
    public Level getLevel()
    {
        return level;
    }
    
    public void setLevel()
    {
        int i=0;
        while(i!=root.getChildren().size()) {
            if(root.getChildren().get(i) instanceof Button ||root.getChildren().get(i) instanceof Label)
                root.getChildren().get(i).setVisible(false);
            if(root.getChildren().get(i) instanceof ImageView)
                root.getChildren().get(i).setVisible(true);
            i++;
        }
        //root.getChildren().add(timer);
        System.out.println("levelbye="+level);
        if(level.getFrequency()==0.03)
            Remaining.start();
        else
        Elapsed.start();
        scoreLabel.setVisible(true);
        Score.setVisible(true);
        Lives.setVisible(true);
        scorePlus.setVisible(true);
        nuketimer.setVisible(false);
        timeLabel.setVisible(true);
  
        bg.setOpacity(1.00);
        control.loop();
    }
    //salah

    public GameObject AddFruits(double x,double y,GameObject fruit)
    {

        Polyline path = new Polyline();
        if(x>=180)
        path.getPoints().addAll(new Double[]{
                x,600.0,
                x, y,
                x-180, 2000.0 });
        if(x<180)
        path.getPoints().addAll(new Double[]{
                x,600.0,
                x, y,
                x-x, 2000.0 });
        spawn = new PathTransition();
        spawn.setNode(fruit.Appearance);
        
        spawn.setDuration(Duration.seconds(5));
        spawn.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        spawn.setPath(path);
        fruit.Appearance.setTranslateX(1000);
        fruit.Appearance.setTranslateY(2000);
        root.getChildren().add(fruit.Appearance);
        spawn.play();

        return fruit;


    }
    public void AddsFruits(double x,double y,GameObject fruit)
    {

        Line path = new Line();
        path.setStartX(x);
        path.setStartY(y);
        path.setEndX(x+500);
        path.setEndY(2000);
        spawn = new PathTransition();
        spawn.setNode(fruit.Appearance);

        spawn.setDuration(Duration.seconds(3));
        spawn.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        spawn.setPath(path);
        fruit.Appearance.setTranslateX(1000);
        fruit.Appearance.setTranslateY(2000);
        root.getChildren().add(fruit.Appearance);
        spawn.play();




    }
    public void setArrayLists(ArrayList<GameObject> spawned,ArrayList<GameObject> sliced) {//khalil
        Spawned=spawned;
        Sliced=sliced;
    }

    public void livesSet(int lives)
    {
        switch(lives)
        {
            case 2:life1.setImage(new Image("/images/healtheaten.png"));break;
            case 1:life1.setImage(new Image("/images/healtheaten.png"));life2.setImage(new Image("/images/healtheaten.png"));break;
            case 0:life1.setImage(new Image("/images/healtheaten.png"));life2.setImage(new Image("/images/healtheaten.png"));life3.setImage(new Image("/images/healtheaten.png"));break;
            
            default:break;


        }
    }
    public void revive()
    {
                    life1.setImage(new Image("/images/health.png"));
                    life2.setImage(new Image("/images/health.png"));
                    life3.setImage(new Image("/images/health.png"));
    }


    public void checkMouse()
    {
        
        
        for(GameObject f:Spawned)
        {
            f.Appearance.setOnMouseEntered(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent e) {
                   if(Nuked==false)
                   {
                    if (!Sliced.contains(f)) {
                        if (f instanceof Special) {
                            scorePlus.setText("+30");
                            timeline.stop();
                            score=control.updateScore(30);
                            delay();
                            //add score logarithm;
                        } else if (f instanceof Normal) {
                            System.out.println("fruit");
                            scorePlus.setText("+10");
                            timeline.stop();
                            score=control.updateScore(10);
                            delay();
                            //add score logarithm;
                        }
                        else if (f instanceof TacticalNuke)
                        {
                            Nuked=true;
                            counter=0;
                            //timer.setTranslateX(290);
                            //timer.setTranslateY(10);
                            nuketimer.setVisible(true);
                            nukeTimer();
                        }
                        else if(level.getFrequency()==0.03&& f instanceof Kaboom)
                        {
                            scorePlus.setText("-50");
                            timeline.stop();
                            score=control.updateScore(-50);
                            delay();
                        }
                        if (f instanceof Normal || f instanceof Passiom)
                        {
                            GameObject r=f.setAppearancecut();
                        AddsFruits(f.Appearance.getTranslateX(),f.Appearance.getTranslateY(),r);
                        }
                        else {
                            f.setAppearance();
                        }

                        scene.setCursor(new ImageCursor(cutknife));                    //khalil
                        //if(f instanceof Fruit)
                        //if(f instanceof Special)
                        control.spawnedRemovesliceAdd(f);                                         //khalil
                        //Sliced.add(f);                                            //khalil
                        if(Nuked==false)
                        control.updateLivesOnSlice(f);                              //kahlil
                    }
                   }
                }

            });
        }
        
    }

    private void delay()
    {
        opac=1;

        reach1=reach2;
        reach2=score;
        System.out.println("Reach1="+reach1);
        System.out.println("Reach2="+reach2);
        System.out.println("Score="+score);
        System.out.println("ScoreAsly="+control.getScore());
        timeline = new Timeline(new KeyFrame(Duration.seconds(.1),(ActionEvent event) -> {
            opac-=0.1;
            scorePlus.setOpacity(opac);
            if(reach1<reach2)
            reach1++;
            if(reach1>reach2)
                reach1--;
            Score.setText(String.valueOf(reach1));
            if(reach1==reach2)
            {

                System.out.println(" "+reach2);
                timeline.stop();
            }




        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void mouseExited()                                                   //khalil
    {
        for(GameObject f:Spawned)
        {
            f.Appearance.setOnMouseExited(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent e) {


                    scene.setCursor(new ImageCursor(knife));

                }


            });
        }
    }
   private void nukeTimer()
   {
       int end = 14;
        Timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            counter++;
            System.out.println("counter "+counter);
            nuketimer.setText(""+(end-counter));
            if(counter==14){
                
                nuketimer.setVisible(false);
                control.updateLivesOnSlice(new TacticalNuke());
                Nuked=false;
                Timer.stop();
                
            }
            
            
        }));
        Timer.setCycleCount(Animation.INDEFINITE);
        Timer.play();
   }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        highC.setText("HighScore: "+String.valueOf(highChild));
        highM.setText("HighScore: "+String.valueOf(highMed));
        highP.setText("HighScore: "+String.valueOf(highPro));
        highA.setText("HighScore: "+String.valueOf(highArc));
        
                
    }
   





}
