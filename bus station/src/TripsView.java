import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class TripsView {

    public void displayTrips(ArrayList<Trip> trips){
        Stage window=new Stage();
        window.setTitle("Trips");
        Label label=new Label("Trips: ");
        label.setFont(Font.font("",24));
        int x=trips.size();
        Label[] labels=new Label[x];
        for(int i=0;i<trips.size();i++){
            labels[i]=new Label("TripID: "+trips.get(i).getTripID()+"  "+"From: "+trips.get(i).getSource()+"  "+"To: "+trips.get(i).getDestination()+"  "+trips.get(i).getDate()+" "+trips.get(i).getTime()+"  "+"Price: "+trips.get(i).getPrice()+"  "+trips.get(i).getType()+" "+trips.get(i).getStopType()+" "+"By: "+trips.get(i).getVehicle().getName());
        }
        Button close=new Button("OK");

        HBox top =new HBox();
        top.getChildren().add(label);
        top.setAlignment(Pos.TOP_LEFT);

        /*ScrollBar scrollBar=new ScrollBar();
        scrollBar.setMin(0);
        scrollBar.setMax(200);
        scrollBar.setValue(110);
        scrollBar.setOrientation(Orientation.VERTICAL);*/

        VBox vBox=new VBox();
        for (int i=0;i<labels.length;i++){
            vBox.getChildren().add(labels[i]);
        }
        vBox.setAlignment(Pos.CENTER);




        HBox bottom=new HBox();
        bottom.getChildren().add(close);
        bottom.setAlignment(Pos.CENTER);

        BorderPane borderPane=new BorderPane();
        borderPane.setTop(top);
        borderPane.setCenter(vBox);
        borderPane.setBottom(bottom);

        close.setOnAction(event -> window.close());

        Scene scene=new Scene(borderPane,700,500);
        window.setScene(scene);
        window.show();

    }


   public void displayDrivers(ArrayList<Driver> drivers){
        Stage window=new Stage();
        window.setTitle("Drivers");
        Label label=new Label("Drivers: ");
        label.setFont(Font.font("",24));
        int x=drivers.size();
        Label[] labels=new Label[x];
        for(int i=0;i<drivers.size();i++){
            labels[i]=new Label("Driver's Name: "+drivers.get(i).getName()+"  "+"Username: "+drivers.get(i).getUsername()+"  "+"Address:  "+drivers.get(i).getAddress()+" "+"Phone Number: "+drivers.get(i).getPhoneNumber());
        }
        Button close=new Button("OK");

        HBox top =new HBox();
        top.getChildren().add(label);
        top.setAlignment(Pos.TOP_LEFT);


        VBox vBox=new VBox();
        for (int i=0;i<labels.length;i++){
            vBox.getChildren().add(labels[i]);
        }
        vBox.setAlignment(Pos.CENTER);

        HBox bottom=new HBox();
        bottom.getChildren().add(close);
        bottom.setAlignment(Pos.CENTER);

        BorderPane borderPane=new BorderPane();
        borderPane.setTop(top);
        borderPane.setCenter(vBox);
        borderPane.setBottom(bottom);

        close.setOnAction(event -> window.close());

        Scene scene=new Scene(borderPane,700,400);
        window.setScene(scene);
        window.show();

    }
}
