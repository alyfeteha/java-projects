/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;

/**
 *
 * @author Lenovo
 */
public class Story1Controller {
    
    Story1Model Model=new Story1Model();
    Story1View View =new Story1View();
    MenueController controller;
    public Story1Controller()
    {
        
    }
    public void send(Story1Model model,Story1View view)
    {
        
        Model=model;
        View=view;
        Link();
        Model.setStage(View.getStage());
        Model.run();
//        check();
        System.out.println("hi");
        
    }
    public void sayHi()
    {
        System.out.println("HI SALOOHA");
    }
    public void Link()
    {
        Model.setCrossers(View.getCrossers());
        Model.setBoat(View.getBoat());
        Model.setRoot(View.getRoot());
        Model.setHarbour1(View.getHarbour1());
        Model.setHarbour2(View.getHarbour2());
        Model.getBorder1(View.getBorder2());
        Model.getBorder2(View.getBorder1());
        
    }
   
     /*public void send(MenueController hi)
    {
        Model=hi.getModel();
        View=hi.getView();
        System.out.println("VIEW1="+View);
        System.out.println("MODEL1="+Model);
    }*/

  
}
