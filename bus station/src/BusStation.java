import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BusStation extends Application {
    AccountValidation accountValidation;

    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Bus Station");

        //Testing
        AssignFiles assignFiles=new AssignFiles();
        //assignFiles.loadCustomerFiles();
//        Customer customer=new Customer();
//        customer.setUsername("feteha_99");
//        ArrayList<Trip> trips=new ArrayList<>();
//        Trip trip=new Trip();
//        trip.setTripID("006");
//        trips.add(trip);
//        customer.setTrips(trips);
//        assignFiles.addTrip(customer);
        //assignFiles.cancelTrip("yos123","002","CustomersTrips.txt");
//        System.out.println(assignFiles.getCustomerTrips().get(0).getTripId());
//        assignFiles.writeCustomerFiles();

//        System.out.println(assignFiles.getCustomerTrips().get(0).getUsername());
        //assignFiles.writeCustomerFiles();

        /*TripsFile tripsFile=new TripsFile();
        tripsFile.loadTrips();
        Trip trip=new Trip();
        trip.setTripID("005");
        trip.setSource("Masr");
        trip.setDestination("Lol");
        trip.setDate("2/3/4444");
        trip.setTime("02:00");
        trip.setType("round");
        trip.setStopType("onestop");
        trip.setPrice("33");
        Vehicle vehicle=new Bus();
        trip.setVehicle(vehicle);
        trip.getVehicle().setAvailableSeats("3");
        tripsFile.add(trip);
        //System.out.println(tripsFile.getCustomerTrips());
        tripsFile.delete("002");
        System.out.println(tripsFile.getTrip("003").getSource());*/


        //Loading files
        LoadInfo loadInfo=new LoadInfo();
        loadInfo.loadCustomer("CustomersInfo.txt");
        loadInfo.loadManager("ManagerInfo.txt");
        loadInfo.loadDriver("DriversInfo.txt");
        //accountValidation class contains database of info
        accountValidation=new AccountValidation();
        accountValidation.setCustomers(loadInfo.getCustomers());
        accountValidation.setManagers(loadInfo.getManagers());
        accountValidation.setDrivers(loadInfo.getDrivers());

        //GUI
        Login login=new Login(accountValidation,primaryStage,loadInfo);
        CustomerForm customerForm=new CustomerForm(primaryStage);
        ManagerForm managerForm=new ManagerForm(primaryStage);
        DriverForm driverForm=new DriverForm(primaryStage);

        login.prepareScene();

        login.setCustomerForm(customerForm);
        login.setManagerForm(managerForm);
        login.setDriverForm(driverForm);

        customerForm.setLogin(login);
        managerForm.setLogin(login);
        driverForm.setLogin(login);

        /*ArrayList<String> trips =new ArrayList<>();
        trips.add("Cairo");
        trips.add("Alex");
        trips.add("Sharm");
        trips.add("Aswan");
        TripsView tripsView=new TripsView();
        tripsView.displayTrips(trips);*/



        primaryStage.setScene(login.getScene());






        primaryStage.show();
    }
}
