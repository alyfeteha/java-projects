/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class RiverCrosser extends Application{

    Stage Window=new Stage();
    @Override
    public void start(Stage primaryStage) throws IOException {
        Window=primaryStage;
        MenueView view=new MenueView();
        MenueModel model=new MenueModel();
        view.setStage(Window);
        MenueController controller=view.display();
        controller.send(view,model);
        
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
