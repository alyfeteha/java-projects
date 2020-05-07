import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;



public class AlertBox {

    public static void display(String text){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Pop-up");
        Button button=new Button("OK");
        button.setOnAction(e->window.close());
        Label label=new Label(text);
        VBox vBox=new VBox(20);
        vBox.getChildren().addAll(label,button);
        vBox.setAlignment(Pos.CENTER);
        Scene scene=new Scene(vBox,300,250);
        window.setScene(scene);
        window.showAndWait();
    }
}
