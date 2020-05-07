import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class ManagerForm {
    private Stage stage;
    private Scene scene;
    private Login login;
    private Manager manager;
    private ConfirmationBox confirmationBox;
    private AssignFiles assignFiles=new AssignFiles();

    public void setAssignFiles(AssignFiles assignFiles) {
        this.assignFiles = assignFiles;
    }

    public void setManager(User manager) {
        this.manager = (Manager) manager;
    }

    public ManagerForm(Stage stage) {
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
        Button view_trips=new Button("View All Trips");
        Button add_trip=new Button("Add Trip");
        Button remove_trip=new Button("Remove Trip");
        Button assign_driver=new Button("Assign driver");
        Button view_drivers=new Button("View Drivers");
        Button logout=new Button("Logout");
        Button exit=new Button("Exit");

        HBox top = new HBox();
        top.getChildren().add(label);
        top.setAlignment(Pos.CENTER_LEFT);

        VBox mid=new VBox(20);
        mid.getChildren().addAll(view_trips,add_trip,remove_trip,view_drivers,assign_driver);
        mid.setAlignment(Pos.CENTER);

        HBox bottom = new HBox(70);
        bottom.getChildren().addAll(logout,exit);
        bottom.setAlignment(Pos.CENTER);

        BorderPane borderPane=new BorderPane();
        borderPane.setTop(top);
        borderPane.setCenter(mid);
        borderPane.setBottom(bottom);

        exit.setOnAction(event -> {
            confirmationBox=new ConfirmationBox();
            confirmationBox.display("Are you sure you want to exit?");
            if(confirmationBox.getResult())
                stage.close();
        });
        logout.setOnAction(event -> stage.setScene(login.getScene()));

        view_trips.setOnAction(event -> {
            manager.viewTrips();
        });

        add_trip.setOnAction(event -> {
            addScene();
        });

        remove_trip.setOnAction(event -> {
            removeScene();
        });

        assign_driver.setOnAction(event -> {
            assign_driverScene();
        });

        view_drivers.setOnAction(event -> {
            manager.viewDrivers();
        });

        scene=new Scene(borderPane,600,400);


    }

    public void addScene(){
        Label label=new Label("Enter trip information: ");
        label.setFont(Font.font(24));
        Label label1=new Label("TripID: ");
        TextField tripID=new TextField();
        Label label2=new Label("Source: ");
        TextField source=new TextField();
        Label label3=new Label("Destination: ");
        TextField destination=new TextField();
        Label label4=new Label("Date: ");
        TextField date=new TextField();
        Label label5=new Label("Time: ");
        TextField time=new TextField();
        Label label6=new Label("Price Oneway: ");
        TextField price=new TextField();
        Label label7=new Label("Stop type");
        ChoiceBox<String> choiceBox1=new ChoiceBox<>();
        choiceBox1.getItems().addAll("Non-stop","One-stop","Many-stops");
        choiceBox1.setValue("Non-stop");
        Label label8=new Label("Type");
        ChoiceBox<String> choiceBox2=new ChoiceBox<>();
        choiceBox2.getItems().addAll("Oneway","Round");
        choiceBox2.setValue("Oneway");
        Label label9=new Label("Vehicle:  ");
        ChoiceBox<String> choiceBox3=new ChoiceBox<>();
        choiceBox3.getItems().addAll("Bus","MiniBus","Limousine");
        choiceBox3.setValue("Bus");
        Button add=new Button("Add Trip");
        Label message=new Label();
        Button back=new Button("Back");


        GridPane gridPane=new GridPane();
        gridPane.add(label,0,0);
        gridPane.add(label1,0,1);
        gridPane.add(tripID,1,1);
        gridPane.add(label2,0,2);
        gridPane.add(source,1,2);
        gridPane.add(label3,0,3);
        gridPane.add(destination,1,3);
        gridPane.add(label4,0,4);
        gridPane.add(date,1,4);
        gridPane.add(label5,0,5);
        gridPane.add(time,1,5);
        gridPane.add(label6,0,6);
        gridPane.add(price,1,6);
        gridPane.add(label7,0,7);
        gridPane.add(choiceBox1,1,7);
        gridPane.add(label8,0,8);
        gridPane.add(choiceBox2,1,8);
        gridPane.add(label9,0,9);
        gridPane.add(choiceBox3,1,9);
        gridPane.add(add,0,11);
        gridPane.add(message,1,11);
        gridPane.setAlignment(Pos.CENTER);

        HBox bottom=new HBox();
        bottom.getChildren().add(back);
        bottom.setAlignment(Pos.CENTER);

        BorderPane borderPane=new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(bottom);

        add.setOnAction(event -> {
            try {
                Trip trip = new Trip();
                trip.setTripID(tripID.getText());
                trip.setSource(source.getText());
                trip.setDestination(destination.getText());
                trip.setDate(date.getText());
                trip.setTime(time.getText());
                trip.setType(choiceBox2.getValue());
                trip.setStopType(choiceBox1.getValue());
                trip.setPrice(price.getText());
                if(choiceBox3.getValue().equals("Bus")){
                    Vehicle bus=new Bus();
                    trip.setVehicle(bus);
                }
                else if(choiceBox3.getValue().equals("MiniBus")){
                    Vehicle minibus=new MiniBus();
                    trip.setVehicle(minibus);
                }
                else {
                    Vehicle limousine=new Limousine();
                    trip.setVehicle(limousine);
                }
                if(choiceBox2.getValue().equals("Round")){
                    trip.discount();
                }
                manager.addTrip(trip);
                message.setText("Successfully Added!");
            }catch (Exception e){
                message.setText("Not added!");
            }
        });

        back.setOnAction(event -> {
            stage.setScene(this.scene);
        });

        Scene addScene=new Scene(borderPane,600,400);
        stage.setScene(addScene);



    }

    public void removeScene(){
        Label label=new Label("Enter tripID: ");
        label.setFont(Font.font(24));
        TextField tripID=new TextField();
        Button remove=new Button("Remove");
        Label message=new Label();
        Button back=new Button("Back");

        /*HBox top=new HBox();
        top.getChildren().add(label);
        top.setAlignment(Pos.CENTER);*/

        GridPane gridPane=new GridPane();
        gridPane.add(label,0,0);
        gridPane.add(tripID,1,0);
        gridPane.add(remove,0,2);
        gridPane.add(message,1,2);
        gridPane.setAlignment(Pos.CENTER);

        HBox bottom=new HBox();
        bottom.getChildren().add(back);
        bottom.setAlignment(Pos.CENTER);

        BorderPane borderPane=new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(bottom);

        remove.setOnAction(event -> {
            String id=tripID.getText();
            if(manager.removeTrip(id))
                message.setText("Successfully Removed!");
            else message.setText("Invalid id");
        });

        back.setOnAction(event -> {
            stage.setScene(this.scene);
        });

        Scene removeScene=new Scene(borderPane,600,400);
        stage.setScene(removeScene);

    }


    public void assign_driverScene(){
        Label label=new Label("Enter tripID: ");
        label.setFont(Font.font(24));
        TextField tripID=new TextField();
        Label label1=new Label("Enter driver username:  ");
        TextField driver_username=new TextField();
        Button assign_driver=new Button("Assign Driver");
        Label message=new Label();
        Button back=new Button("Back");

        /*HBox top=new HBox();
        top.getChildren().add(label);
        top.setAlignment(Pos.CENTER);*/

        GridPane gridPane=new GridPane();
        gridPane.add(label,0,0);
        gridPane.add(tripID,1,0);
        gridPane.add(label1,0,2);
        gridPane.add(driver_username,1,2);
        gridPane.add(assign_driver,0,3);
        gridPane.add(message,1,3);
        gridPane.setAlignment(Pos.CENTER);

        HBox bottom=new HBox();
        bottom.getChildren().add(back);
        bottom.setAlignment(Pos.CENTER);

        BorderPane borderPane=new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(bottom);

        assign_driver.setOnAction(event -> {
            String id=tripID.getText();
            String driver=driver_username.getText();
            if(manager.assignDrivers(id,driver))
                message.setText("Successfully Assigned Driver!");
        });

        back.setOnAction(event -> {
            stage.setScene(this.scene);
        });

        Scene removeScene=new Scene(borderPane,600,400);
        stage.setScene(removeScene);
    }
}
