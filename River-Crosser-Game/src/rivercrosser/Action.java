/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

public class Action {
    
    Command theCommand;
    
    public Action(Command newCommand)
    {
        theCommand=newCommand;
    }
    public void Perform()  
    {
        theCommand.execute();
    }
    public void pressUndo()
    {
        theCommand.undo();
    }
           
}
