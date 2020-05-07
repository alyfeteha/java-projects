import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class DriverForm {
    private Stage stage;
    private Scene scene;
    private Login login;
    private Driver driver;


    public void setDriver(User driver) {
        this.driver =(Driver) driver;
    }

    public DriverForm(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void prepareScene(){
        Label label=new Label("Driver's Profile:");
        label.setFont(Font.font("Arial",20));
        Label label1=new Label("  Name:  "+driver.getName());
        Label label2=new Label("  Address:  "+driver.getAddress());
        Label label3=new Label("  Phone Number:  "+driver.getPhoneNumber());
        Button button=new Button("View assigned trips");
        Button logout=new Button("Logout");
        Button exit=new Button("Exit");

        HBox top=new HBox();
        top.getChildren().add(label);
        top.setAlignment(Pos.TOP_LEFT);

        VBox mid=new VBox();
        mid.getChildren().addAll(label1,label2,label3);
        mid.setAlignment(Pos.CENTER_LEFT);

        HBox bottom=new HBox(100);
        bottom.getChildren().addAll(logout,button,exit);
        bottom.setAlignment(Pos.CENTER);

        BorderPane borderPane=new BorderPane();
        borderPane.setTop(top);
        borderPane.setCenter(mid);
        borderPane.setBottom(bottom);

        button.setOnAction(event -> {
            driver.viewTrips();
        });
        exit.setOnAction(event -> {
            ConfirmationBox confirmationBox=new ConfirmationBox();
            confirmationBox.display("Are you sure you want to exit?");
            if(confirmationBox.getResult())
                stage.close();
        });
        logout.setOnAction(event -> stage.setScene(login.getScene()));

        scene=new Scene(borderPane,600,400);

    }
}
