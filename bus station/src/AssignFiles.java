import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class AssignFiles  {
    private ArrayList<Customer> customerTrips=new ArrayList<>();
    private ArrayList<Driver> driverTrips=new ArrayList<>();
    private TripsFile tripsFile;;
    private Scanner x;
    private Customer customer;
    private Driver driver;
    private Trip trip;
    private LoadInfo loadInfo;
//    private Formatter y;


    public void addTrip(String username,Trip trip){
        Customer customer=new Customer();
        customer.setUsername(username);
        customer.addTrip(trip);
        customerTrips.add(customer);
        writeCustomerFiles();
    }

    //might delete useless!!!!!
    //AT start-up for reserved seats
    public void loadCustomerFiles(){
        try{
            x=new Scanner(new File("CustomersTrips.txt"));
            tripsFile=new TripsFile();
            tripsFile.loadTrips();
            loadInfo=new LoadInfo();
            loadInfo.loadCustomer("CustomersInfo.txt");
            while (x.hasNext()){
                String name= x.next();
                String id =x.next();
                System.out.println(name+" "+id);
                customer=loadInfo.getCustomer(name);
                trip=new Trip();
                trip=tripsFile.getTrip(id);
                customer.addTrip(trip);
                customerTrips.add(customer);
                System.out.println("customer added");

            }
            x.close();
        }catch (Exception e){
            System.out.println(e);
            AlertBox.display("Error in loading customer file");
        }
    }


    public void writeCustomerFiles(){
        try{
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("CustomersTrips.txt",false));
            int i=0,j;
            while (i < customerTrips.size()){
                Customer customer=customerTrips.get(i);
                System.out.println("writing in customer file");
                bufferedWriter.write(customer.getUsername()+" ");
                bufferedWriter.write(customer.getTrips().get(customer.getTripsIndex()).getTripID());
                customer.setTripIndex();
                bufferedWriter.newLine();
                i++;
            }
            bufferedWriter.close();
        }
        catch (Exception e){
            System.out.println(e);
            AlertBox.display("Error in writing in customer file");
        }
    }

    public void loadDriverFiles(){
        try{
            x=new Scanner(new File("DriversTrips.txt"));
            tripsFile=new TripsFile();
            tripsFile.loadTrips();
            loadInfo=new LoadInfo();
            loadInfo.loadDriver("DriversInfo.txt");
            while (x.hasNext()){
                String name= x.next();
                String id =x.next();
                System.out.println(name+" "+id);
                driver=loadInfo.getDriver(name);
                trip=new Trip();
                trip=tripsFile.getTrip(id);
                driver.addTrip(trip);
                driverTrips.add(driver);
                System.out.println("driver added");

            }
            x.close();
        }catch (Exception e){
            System.out.println(e);
            AlertBox.display("Error in loading customer file");
        }
    }

    public void writeDriverFiles(){
        try{
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("DriversTrips.txt",false));
            int i=0;
            while (i < driverTrips.size()){
                Driver driver=driverTrips.get(i);
                System.out.println("writing in driver file");
                bufferedWriter.write(driver.getUsername()+" ");
                bufferedWriter.write(driver.getTrips().get(driver.getTripsIndex()).getTripID());
                driver.setTripIndex();
                bufferedWriter.newLine();
                i++;
            }
            bufferedWriter.close();
        }
        catch (Exception e){
            System.out.println(e);
            AlertBox.display("Error in writing in customer file");
        }
    }

    public ArrayList<Trip> getCustomerTrips(String username){
        for(int i=0;i<customerTrips.size();i++){
            Customer customer=customerTrips.get(i);
            if(customer.getUsername().equals(username))
                return customer.getTrips();
        }
            System.out.println("Not found");
            return null;

    }

    public ArrayList<Trip> getDriverTrips(String username){
        for(int i=0;i<driverTrips.size();i++){
            Driver driver=driverTrips.get(i);
            if(driver.getUsername().equals(username))
                return driver.getTrips();
        }
        System.out.println("Not found");
        return null;
    }

    public Driver getDriver(String username){
        for(int i=0;i<driverTrips.size();i++){
            Driver driver=driverTrips.get(i);
            if(driver.getUsername().equals(username))
                return driver;
        }
        System.out.println("Not found");
        return null;
    }


    public ArrayList<Customer> getCustomerTrips() {
        return customerTrips;
    }




    //Delete from file
    public void cancelCustomerTrip(String username,String  id){
        for(int i=0;i<customerTrips.size();i++){
            Customer customer=customerTrips.get(i);
            if(customer.getUsername().equals(username)){
                for(int j=0;j<customer.getTrips().size();j++){
                    if(customer.getTrips().get(j).getTripID().equals(id)){
//                        System.out.println("Found deleting");
                        customer.getTrips().remove(j);
                        customerTrips.remove(i);
                        customer.setTripIndex();
                    }
                }
            }
        }
        writeCustomerFiles();
    }

//    public void cancelCustomerTrip(String  id){
//        for(int i=0;i<customerTrips.size();i++){
//            Customer customer=customerTrips.get(i);
//                for(int j=0;j<customer.getTrips().size();j++){
//                    if(customer.getTrips().get(j).getTripID().equals(id)){
//                        customer.getTrips().remove(j);
//                        customerTrips.remove(i);
//                        customer.setTripIndex();
//                    }
//                }
//
//        }
//        writeCustomerFiles();
//    }

    public void addDriver(String username,Trip trip){
        Driver driver=new Driver();
        driver.setUsername(username);
        driver.addTrip(trip);
        driverTrips.add(driver);
        writeDriverFiles();
    }



}
