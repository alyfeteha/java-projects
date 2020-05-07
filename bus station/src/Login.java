import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;


public class Login {
    private Scene scene;
    private Stage stage;
    private User user;
    private AccountValidation accountValidation;
    private CustomerForm customerForm;
    private ManagerForm managerForm;
    private DriverForm driverForm;
    private LoadInfo loadInfo;
    private TripsFile tripsFile;
    private AssignFiles assignFiles;


    public Login(AccountValidation accountValidation,Stage stage,LoadInfo loadInfo) {
        this.accountValidation = accountValidation;
        this.stage=stage;
        this.loadInfo=loadInfo;
    }

    public void prepareScene() {
        Label label1=new Label("Welcome");
        label1.setFont(Font.font(28));
        label1.setTextFill(Color.web("3433FF"));
        Label label2=new Label("Username: ");
        Label label3=new Label("Password: ");
        TextField t1=new TextField();
        t1.setPromptText("Enter username");
        PasswordField t2=new PasswordField();
        t2.setPromptText("Enter password");
        Button button=new Button("Login");
        ChoiceBox<String> choiceBox=new ChoiceBox<>();
        choiceBox.getItems().addAll("Customer","Manager","Driver");
        choiceBox.setValue("Customer");

        GridPane gridPane=new GridPane();
        gridPane.add(label2,0,0);
        gridPane.add(t1,1,0);
        gridPane.add(label3,0,1);
        gridPane.add(t2,1,1);
        gridPane.add(choiceBox,2,0);
        gridPane.add(button,0,2);
        gridPane.setAlignment(Pos.CENTER);

        VBox vBox=new VBox(60);
        vBox.getChildren().addAll(label1,gridPane);
        vBox.setAlignment(Pos.CENTER);
        button.setOnAction(event -> {
            String username=t1.getText();
            String password=t2.getText();
            String choice=choiceBox.getValue();
            if(username.isEmpty() || password.isEmpty())
                AlertBox.display("Missing input!");
            else {
                if (choice.equals("Customer")) {
                    user = new Customer();
                    user.setUsername(username);
                    user.setPassword(password);
                    if (((Customer) user).validate(accountValidation)) {
                        AlertBox.display("Welcome " + username);
                        tripsFile = new TripsFile();
                        //tripsFile.loadTrips();
                        //assignFiles.loadCustomerFiles((Customer) user);
                        user = loadInfo.getCustomer(username);
                        customerForm.setCustomer(user);
                        customerForm.prepareScene();
                        stage.setScene(customerForm.getScene());
                    }

                } else if (choice.equals("Manager")) {
                    user = new Manager();
                    user.setUsername(username);
                    user.setPassword(password);
                    if (((Manager) user).validate(accountValidation)) {
                        AlertBox.display("Welcome Mr. " + username);
                        tripsFile = new TripsFile();
                        //tripsFile.loadTrips();
                        assignFiles = new AssignFiles();
                        //assignFiles.loadCustomerFiles();
                        user = loadInfo.getManager(username);
                        managerForm.setManager(user);
                        managerForm.prepareScene();
                        stage.setScene(managerForm.getScene());
                    }

                } else {
                    user = new Driver();
                    user.setUsername(username);
                    user.setPassword(password);
                    if (((Driver) user).validate(accountValidation)) {
                        tripsFile = new TripsFile();
                        //tripsFile.loadTrips();
                        assignFiles = new AssignFiles();
                        //assignFiles.loadCustomerFiles();
                        user = loadInfo.getDriver(username);
                        driverForm.setDriver(user);
                        driverForm.prepareScene();
                        stage.setScene(driverForm.getScene());
                    }

                }
            }

        });

        scene=new Scene(vBox,600,400);

    }


    public Scene getScene(){
        return scene;
    }

    public void setCustomerForm(CustomerForm customerForm) {
        this.customerForm = customerForm;
    }

    public void setManagerForm(ManagerForm managerForm) {
        this.managerForm = managerForm;
    }

    public void setDriverForm(DriverForm driverForm) {
        this.driverForm = driverForm;
    }
}
