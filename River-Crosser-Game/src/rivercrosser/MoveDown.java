/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

public class MoveDown implements Command{
    
    GameObject obj;
    
    public MoveDown(GameObject obj)
    {
        this.obj=obj;
    }
    public void execute() {
        obj.moveDown();
    }

    public void undo() {
        obj.moveUp();
    }
    
 
}
