/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

public class MoveRight implements Command{
    
    GameObject obj;
    
    public MoveRight(GameObject obj)
    {
        this.obj=obj;
    }
    public void execute() {
        obj.moveRight();
    }

    public void undo() {
        obj.moveLeft();
    }
    
}
