/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class MenueController implements Initializable {

      MenueView theView;
      MenueModel theModel;
      private Story1Model model=new Story1Model();
      private Story1View view=new Story1View();
    
 
    public MenueController() {
        
    } 
    
    public void send(MenueView theView, MenueModel theModel) {
        System.out.println("Constructed Menue controller (we have view and model for main menue osama)");
        this.theView = theView;
        this.theModel = theModel;
        System.out.println("view="+this.theView.getStage());
        System.out.println("view="+theView.getStage());
       
       
    }
    public void displayStory1() throws IOException
    {
      Story1Model model=new Story1Model();
      Story1View view=new Story1View();
      view.setStage(theView.getStage());
      Story1Controller controller=view.display();
      System.out.println("Cont1="+controller);
      System.out.println("VIEW="+view);
      System.out.println("MODEL="+model);
      controller.send(model,view);
      //controller.send(this);
      
      
    }
    public void displayStory2()
    {
        Story2Model model=new Story2Model();
      Story2View view=new Story2View();
      view.setStage(theView.getStage());
      Story2Controller controller=view.display();
      System.out.println("Cont1="+controller);
        System.out.println("VIEW="+view);
        System.out.println("MODEL="+model);
       controller.send(model,view);
        //theModel.startStory2();
    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * @return the model
     */
    public Story1Model getModel() {
        return model;
    }

    /**
     * @return the view
     */
    public Story1View getView() {
        return view;
    }
    
}
