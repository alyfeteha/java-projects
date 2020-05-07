import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ConfirmationBox {
    private  boolean result;
    private Stage window;

    public  void display(String text){
        window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Confirmation");
        Button yes=new Button("Yes");
        Button no=new Button("No");
        Label label=new Label(text);
        VBox vBox=new VBox(20);
        vBox.getChildren().addAll(label,yes,no);
        vBox.setAlignment(Pos.CENTER);
        yes.setOnAction(event -> {
            result =true;
            window.close();
        });
        no.setOnAction(event -> {
            result = false;
            window.close();
        });
        Scene scene=new Scene(vBox,300,250);
        window.setScene(scene);
        window.showAndWait();


    }

    public boolean getResult(){
        return result;
    }
}
