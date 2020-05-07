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
public class Story2Controller {
     Story2Model Model=new Story2Model();
    Story2View View=new Story2View();
    MenueController controller;
    public Story2Controller()
    {
        
    }
    public void send(Story2Model model,Story2View view)
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
