/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

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
        
    }
    public void sayHi()
    {
        System.out.println("HI SALOOHA");
    }
     /*public void send(MenueController hi)
    {
        Model=hi.getModel();
        View=hi.getView();
        System.out.println("VIEW1="+View);
        System.out.println("MODEL1="+Model);
    }*/
}
