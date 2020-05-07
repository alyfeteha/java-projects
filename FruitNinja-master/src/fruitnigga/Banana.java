package fruitnigga;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class Banana extends Special {
    Node Appearance = new Circle(60,new ImagePattern(new Image(getClass().getResourceAsStream("/Images/Banana.png"))));
    public Banana() {
        super();
        super.Appearance=Appearance;

    }
    public void setAppearance() {
        ImagePattern cut= new ImagePattern(new Image(getClass().getResourceAsStream("/Images/cutBanana.png")));
        play();
        ((Circle)super.Appearance).setFill(cut);
    }
}
