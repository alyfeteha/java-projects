package fruitnigga;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class Passiom extends Special {
    Node Appearance = new Circle(60,new ImagePattern(new Image(getClass().getResourceAsStream("/Images/Passiom.png"))));
    public Passiom() {
        super();
        super.Appearance=Appearance;

    }
    public Passiom setAppearancecut() {

        ImagePattern cut= new ImagePattern(new Image(getClass().getResourceAsStream("/Images/cutPassiom.png")));
        ImagePattern cut2= new ImagePattern(new Image(getClass().getResourceAsStream("/Images/cutPassiom2.png")));
        play();
        ((Circle)super.Appearance).setFill(cut);
        Passiom neww=new Passiom();
        neww.Appearance.setTranslateY(this.Appearance.getTranslateY());
        ((Circle)neww.Appearance).setFill(cut2);
        neww.Appearance.setTranslateX(neww.Appearance.getTranslateX()+50);
        return neww;

    }

}
