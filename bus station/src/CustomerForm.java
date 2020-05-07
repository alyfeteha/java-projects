import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class CustomerForm {
    private Stage stage;
    private Scene scene;
    private Login login;
    private Customer customer;
    private ConfirmationBox confirmationBox;
    private TripsView tripsView=new TripsView();
    private AssignFiles assignFiles=new AssignFiles();
    private TripsFile tripsFile=new TripsFile();


    public void setAssignFiles(AssignFiles assignFiles) {
        this.assignFiles = assignFiles;
    }

    public void setCustomer(User customer) {
        this.customer = (Customer) customer;
    }

    public CustomerForm(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void prepareScene(){
        Label label=new Label("Select a command: ");
        Button b1=new Button("View Trips");
        Button b2=new Button("Book Trip");
        Button b3=new Button("Cancel Trip");
        Button b4=new Button("View reserved Trips");
        Button logout=new Button("Logout");
        Button exit=new Button("Exit");

        HBox top = new HBox();
        top.getChildren().add(label);
        top.setAlignment(Pos.CENTER_LEFT);

        HBox mid=new HBox(40);
        mid.getChildren().addAll(b1,b2,b3,b4);
        mid.setAlignment(Pos.CENTER);

        HBox bottom = new HBox(70);
        bottom.getChildren().addAll(logout,exit);
        bottom.setAlignment(Pos.CENTER);

        BorderPane borderPane=new BorderPane();
        borderPane.setTop(top);
        borderPane.setCenter(mid);
        borderPane.setBottom(bottom);

        scene=new Scene(borderPane,600,400);

        exit.setOnAction(event -> {
            confirmationBox=new ConfirmationBox();
            confirmationBox.display("Are you sure you want to exit?");
            if(confirmationBox.getResult())
                stage.close();
        });
        logout.setOnAction(event -> {
                stage.setScene(login.getScene());
        });


        b1.setOnAction(event -> {
            customer.viewAllTrips();
        });

        b2.setOnAction(event -> {
            bookScene();
        });

        b3.setOnAction(event -> {
            cancelScene();

        });

        b4.setOnAction(event -> {
            assignFiles.loadCustomerFiles();
            customer.viewTrips();
        });



    }





    public void bookScene(){
        Label label=new Label("Enter tripID: ");
        label.setFont(Font.font(24));
        TextField tripID=new TextField();
        Button reserve=new Button("Reserve");
        Label message=new Label();
        Button back=new Button("Back");

        /*HBox top=new HBox();
        top.getChildren().add(label);
        top.setAlignment(Pos.CENTER);*/

        GridPane gridPane=new GridPane();
        gridPane.add(label,0,0);
        gridPane.add(tripID,1,0);
        gridPane.add(reserve,0,2);
        gridPane.add(message,1,2);
        gridPane.setAlignment(Pos.CENTER);

        HBox bottom=new HBox();
        bottom.getChildren().add(back);
        bottom.setAlignment(Pos.CENTER);

        BorderPane borderPane=new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(bottom);

        reserve.setOnAction(event -> {
            String id=tripID.getText();
            if(customer.reserveTrip(id))
                message.setText("Trip reserved successfully!");
        });

        back.setOnAction(event -> {
            stage.setScene(this.scene);
        });

        Scene scene=new Scene(borderPane,600,400);
        stage.setScene(scene);
    }


    public void cancelScene(){
        Label label=new Label("Enter tripID: ");
        label.setFont(Font.font(24));
        TextField tripID=new TextField();
        Button cancel=new Button("Cancel");
        Label message=new Label();
        Button back=new Button("Back");

        /*HBox top=new HBox();
        top.getChildren().add(label);
        top.setAlignment(Pos.CENTER);*/

        GridPane gridPane=new GridPane();
        gridPane.add(label,0,0);
        gridPane.add(tripID,1,0);
        gridPane.add(cancel,0,2);
        gridPane.add(message,1,2);
        gridPane.setAlignment(Pos.CENTER);

        HBox bottom=new HBox();
        bottom.getChildren().add(back);
        bottom.setAlignment(Pos.CENTER);

        BorderPane borderPane=new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(bottom);

        cancel.setOnAction(event -> {
            String id=tripID.getText();
            if(customer.cancelTrip(id))
                message.setText("Trip cancelled");
        });

        back.setOnAction(event -> {
            stage.setScene(this.scene);
        });

        Scene scene=new Scene(borderPane,600,400);
        stage.setScene(scene);
    }

}
