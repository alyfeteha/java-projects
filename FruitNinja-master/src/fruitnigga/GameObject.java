/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitnigga;

import javafx.scene.Node;

/**
 *
 * @author Lenovo
 */
public abstract class  GameObject {
   Node Appearance;



    public GameObject()
    {
        this.Appearance=Appearance;

    }

    public abstract void setAppearance();
    public abstract GameObject setAppearancecut();
  
    
}
