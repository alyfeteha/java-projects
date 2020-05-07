/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.awt.geom.Point2D;
import javafx.scene.Node;

/**
 *
 * @author Lenovo
 */
public class Crosser {
    private Node Appearance;
    private int Speed;
    private int Weight;
    private boolean Crossed;
    private boolean OnBoat;
    private String Name;
    
    public Crosser(Node Appearance,int Weight,String Name)
    {
        this.Appearance=Appearance;
        this.Weight=Weight;
        this.Name=Name;
        Speed=10-(this.Weight/10);
    }

    /**
     * @return the Appearance
     */
    public Node getAppearance() {
        return Appearance;
    }

    /**
     * @param Appearance the Appearance to set
     */
    public void setAppearance(Node Appearance) {
        this.Appearance = Appearance;
    }

    /**
     * @return the Speed
     */
    public int getSpeed() {
        return Speed;
    }

    /**
     * @param Speed the Speed to set
     */
    public void setSpeed(int Speed) {
        this.Speed = Speed;
    }

    /**
     * @return the Weight
     */
    public int getWeight() {
        return Weight;
    }

    /**
     * @param Weight the Weight to set
     */
    public void setWeight(int Weight) {
        this.Weight = Weight;
    }

    /**
     * @return the Crossed
     */
    public boolean isCrossed() {
        return Crossed;
    }

    /**
     * @param Crossed the Crossed to set
     */
    public void setCrossed(boolean Crossed) {
        this.Crossed = Crossed;
    }

    /**
     * @return the OnBoat
     */
    public boolean isOnBoat() {
        return OnBoat;
    }

    /**
     * @param OnBoat the OnBoat to set
     */
    public void setOnBoat(boolean OnBoat) {
        this.OnBoat = OnBoat;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }
    
}
