
package rivercrosser;
     
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

//Y-AXIS 221 UPPER Y-AXIS 430 LOWER
//X-AXIS 557 RIGHT X-AXIS 38 LEFT
public class Story1Model {

    private ArrayList<Crosser> Crossers = new ArrayList<Crosser>();
    private ArrayList<Crosser> Crossed = new ArrayList<Crosser>();
    private ArrayList<Crosser> onBoat = new ArrayList<Crosser>();
    private ArrayList<Crosser> onShore = new ArrayList<Crosser>();
    AnimationTimer timer;
    MoveDown moveDown;
    MoveUp moveUp;
    MoveLeft moveLeft;
    MoveRight moveRight;
    Action action ;
    private Stage stage;
    boolean Controlled;
    private Boat boat;
    private Pane root;
    private Node Harbour1;
    private Node Harbour2;
    private boolean harb1;
    private boolean harb2;
    private Node Border1;
    private Node Border2;
    int NumberOfMoves;
    GameObject player;
    String musicFile = "missiam.mp3"; 
    Media sound = new Media(new File(musicFile).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);
   private XMLwrite saver = new XMLwrite();
    //Story1View View =new Story1View();
    public void setCrossers(ArrayList<Crosser> crossers)
     {
         
        this.Crossers=crossers;
        for(Crosser cross:crossers)
        {
            onShore.add(cross);
        }
         System.out.println("adding crossers");
        
     }
    public void setBoat(Boat b)
    { 
        boat=b;   
    }
    public Story1Model RunStory1()
    {
      //  System.out.println("Number of moves "+NumberOfMoves);
        Border1.setVisible(false);
        Border2.setVisible(false);
        GameStatus();
        
        EndGame();
               harbourStatus();
               stage.getScene().setOnKeyPressed(e->{
                   
                   if(Controlled ==true)
                   {
                         if(player instanceof Boat)
                         {canMove();}
                         if(e.getCode()==KeyCode.DOWN)
                        {
                           
                            if(player.Appearance.getTranslateY()<550&&player.Appearance.getBoundsInParent().intersects(Border2.getBoundsInParent())==false&&!(player instanceof Boat))
                             moveDown.execute();
                            if(player.Appearance.getTranslateY()<550&&player.Appearance.getBoundsInParent().intersects(Border1.getBoundsInParent())==false&&player instanceof Boat)
                            moveDown.execute();
                        }
                        if(e.getCode()==KeyCode.UP)
                        {
                             if(player.Appearance.getTranslateY()>60&&player.Appearance.getBoundsInParent().intersects(Border1.getBoundsInParent())==false&&!(player instanceof Boat))
                             {
                                
                                moveUp.execute();
                             }
                             if(player.Appearance.getTranslateY()>60&&player.Appearance.getBoundsInParent().intersects(Border2.getBoundsInParent())==false&&player instanceof Boat)
                            moveUp.execute();
                        }
                        if(e.getCode()==KeyCode.LEFT)
                        {
                          //  System.out.println(" X = "+player.Appearance.getTranslateX());
                            if(player.Appearance.getTranslateX()>30)
                            moveLeft.execute();
                        }
                        if(e.getCode()==KeyCode.RIGHT)
                        {
                           if(player.Appearance.getTranslateX()<540)
                            moveRight.execute();
                        }
                         if(e.getCode()==KeyCode.E)
                        {
                            
                           if(harb1==true)
                           {
                               getOffBoat(1);

                           }
                            if(harb2==true)
                            {
                                getOffBoat(2);

                            }
                            
                        }
                         if(e.getCode()==KeyCode.S)
                         {
                             Save();
                         }
                   }
               });
           
               
               stage.getScene().setOnMouseClicked(e->{
                    
                 for(Crosser cross:Crossers)
                         {
                             if(e.getTarget()==cross.getAppearance())
                             {
                                // System.out.println("clicke");
                               //  Controlled= new Crosser();
                                // Controlled = cross;
                                 ControlThis(cross);
                                 break;
                             }
                            if(e.getTarget()==boat.Appearance)
                            {
                                if(boat.drivable==true)
                                {
                                   // Controlled = new Boat();
                                    //Controlled=boat;
                                    if(true)
                                    {
                                   //     System.out.println("ye5");
                                         ControlThis(boat);
                                         
                                    }
                                        break;
                                }
                            }
                         }
             
               });
               
    
            
                return this;
      
    }
    
   public void setRoot(Pane root)
   {
       this.root=root;
   }
   public  void setStage(Stage stage)
    {
        this.stage=stage;
    }
   private void getOnBoat(Crosser crosser)
   {
       
       onBoat.add(crosser);
       //System.out.println("added");
       Crossers.remove(crosser);

       if(harb2==true) {
           onShore.remove(crosser);
           System.out.println("moving from shore");

       }
       if(harb1==true)
       {
           Crossed.remove(crosser);
           System.out.println("moving from other side");
       }
       
       crosser.getAppearance().setTranslateX(0);
       crosser.getAppearance().setTranslateY(0);
       root.getChildren().remove(crosser.getAppearance());
       boat.Passengers++;
       System.out.println("Boat passengers: "+boat.Passengers);

   }
  
   private void getOffBoat(int HarbourNumber)
   {
       
       //boat=(Boat) Controlled;
       System.out.println("getting off");
       double x=45;
       root.getChildren().remove(boat.Appearance);
      
       for(Crosser cross:onBoat)
       {
           Crossers.add(cross);
        
           if(HarbourNumber==1)
           {
        
           cross.getAppearance().setTranslateX(Harbour1.getTranslateX()+x);
           cross.getAppearance().setTranslateY(435);
           boat.Appearance.setTranslateX(Harbour1.getTranslateX()+45);
           boat.Appearance.setTranslateY(Harbour1.getTranslateY()-30);
           Crossed.add(cross);
           harb1=true;
           harb2=false;
    //        <BorderPane layoutX="36.0" layoutY="426.0" prefHeight="158.0" prefWidth="534.0" />
     // <BorderPane layoutX="46.0" layoutY="48.0" prefHeight="171.0" prefWidth="514.0" />
           }
           if(HarbourNumber==2)
           {
               
           cross.getAppearance().setTranslateX(Harbour2.getTranslateX()-x);
           cross.getAppearance().setTranslateY(160);  
           boat.Appearance.setTranslateX(Harbour2.getTranslateX()+45);
           boat.Appearance.setTranslateY(Harbour2.getTranslateY()+30);
        
           onShore.add(cross);
            
           
           harb2=true;
           harb1=false;
           }
           root.getChildren().add(cross.getAppearance());
           
           x=55;   
           boat.Passengers--;
           System.out.println("Boat passengers: "+boat.Passengers);
       }
       
         onBoat.clear();
        boat.drivable=false;
        Controlled=false;
        root.getChildren().add(boat.Appearance);
      //  Crossers.clear();
   }
   private void ControlThis(GameObject thing)
   {
       Controlled = true;
        player=thing;
       moveDown=new MoveDown(thing);
       moveUp = new MoveUp(thing);
       moveLeft=new MoveLeft(thing);
       moveRight=new MoveRight(thing);
   }

    

    public boolean isBoatOnTheLeftBank() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void canMove() {
        int i;
        int j;
        boolean stop = false;
        if(harb2==true) {
            System.out.println("true harb 2");
            for (i = 0; i < onShore.size(); i++) {
                   // System.out.println("Number on Shore "+onShore.size());
                   // System.out.println(" eating rank on shore " + onShore.get(i).getEatingRank());
                    for (j = 0; j < onShore.size(); j++) {
                        
                        if (onShore.get(i).getEatingRank() == onShore.get(j).getEatingRank() + 1)
                        {
                            //System.out.println("m3elsalama");//window yetla3 aw ay ebn metnaka
                            //return false;
                             AlertBox.display("TAKE CARE","Invalid Move");
                             NumberOfMoves++;
                             Controlled=false;
                             getOffBoat(2);
                             stop = true;
                        }

                    }
                if(stop==true)
                {
                    break;
                }
            }
          //  return true;

        }


        if(harb1==true) {
            for (i = 0; i < Crossed.size(); i++) {
                System.out.println("true harb 1");
               // System.out.println("Number on other side "+Crossed.size());
               // System.out.println(" Eatin rank at other side" + Crossed.get(i).getEatingRank());
           
                    for (j = 0; j < Crossed.size(); j++) {
                        if (Crossed.get(i).getEatingRank() == Crossed.get(j).getEatingRank() + 1) {
                             AlertBox.display("TAKE CARE","Invalid Move");
                             NumberOfMoves++;
                             Controlled=false;
                             getOffBoat(1);
                             stop=true;
                             //System.out.println("M3 el salama other side"); //window yetla3 aw ay ebn metnaka
                        }

                    }
                        if(stop==true)
                       {
                            break;
                       }
            }

        }
    }

  public void harbourStatus()
  {
          if(boat.atHarbour(Harbour1))
                 { System.out.println("Arrived on the Other Side!");
                     harb1=true;
                     harb2=false;
                    // if(boat.Passengers>=0)
                     getOffBoat(1);
                     System.out.println("Shore has "+onShore.size()+"and Other side has "+Crossed.size());
                     NumberOfMoves++;
                 }
                 else if(boat.atHarbour(Harbour2))
                 {
                      System.out.println("Arrived on Shore!");
                      //if(boat.Passengers>=0)
                      harb2=true;
                      harb1=false;
                      getOffBoat(2);
                      System.out.println("Shore has "+onShore.size()+"and Other side has "+Crossed.size());
                      NumberOfMoves++;
                      
                 }
       else {
                  for(Crosser cross:Crossed)
              {
             
                if(cross.isColliding(Harbour1)&&harb1==true)
                {
                    if(boat.Passengers<2)
                    {
                          
                        //System.out.println("shore");
                        if(cross instanceof Farmer)
                            {
                                boat.drivable=true;
                                //harb1=true;
                            }
                                getOnBoat(cross);
                                System.out.println("Now there are "+Crossed.size()+" On The Other Side");
                                System.out.println("And "+onShore.size()+" OnShore");
                                break;
                                
                    }
                }
              }
             for(Crosser cross:onShore)
             {
                if(cross.isColliding(Harbour2)&&harb2==true)
                {
                    if(boat.Passengers<2)
                    {
                      //  System.out.println("getting on from Shore");
                       
                        if(cross instanceof Farmer)
                            {
                                boat.drivable=true;
                                //harb1=true;
                            }
                                 getOnBoat(cross);
                                 System.out.println("Now there are "+onShore.size()+" On Shore");
                                 System.out.println("And there are "+Crossed.size()+" On The Other Side");
                                 break;
                                
                    }
                }
               
            }
          }  
  }
   
   public void setHarbour1(Node harbour1)
   {
       this.Harbour1=harbour1;
       harb2=true;
       
   }
   public void setHarbour2(Node harbour2)
   {
       this.Harbour2=harbour2;
       
   }
   public void getBorder1(Node border)
   {
       Border1=border;
   }
   public void getBorder2(Node border)
   {
       Border2=border;
   }
    public void run()
   {
       
        timer = new AnimationTimer() {
            
            @Override
            public void handle(long now) {
            RunStory1();
            } 
        };
        timer.start();
   }
    private void GameStatus()
    {
       // System.out.println(" FINSI ");
        if(Crossed.size()==4)
        {
            EndGame();
        }
    }
    public void EndGame()
    {
        Node finish;
        finish = new Rectangle(500,200,new ImagePattern(new Image(getClass().getResourceAsStream("/rivercrosser/Images/missiam.jpg"))));
        finish.setTranslateX(55);
        finish.setTranslateY(200);
       
        
        if(Crossed.size()==4)
        {
            timer.stop();
            mediaPlayer.play();
            root.getChildren().add(finish);
             // AlertBox.display("YAY","YOU WIN");
            
             
              //return true;
        }
        
    }
    public void Save()
    {
        FillArrayList filler= new FillArrayList();
        
        filler.SaveToArrays(onShore, onBoat, Crossed);
        
        System.out.println("Onshore Size : "+onShore.size());
         System.out.println("Crossed Size : "+Crossed.size());
          System.out.println("OnBoar : "+onBoat.size());
       saver.arrayLeft(filler.LeftCrossers);
       saver.arrayRight(filler.RightCrossers);
       saver.arrayonboat(filler.onboatCrossers);
       
        System.out.println("Onshore Size : "+saver.L.size());
         System.out.println("Crossed Size : "+saver.R.size());
          System.out.println("OnBoar : "+saver.O.size());
          
       saver.writeXML();
    }
}
