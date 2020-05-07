import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LoadInfo {
    private HashMap<String,Customer> customers=new HashMap<>();
    private HashMap<String,Manager> managers=new HashMap<>();
    private HashMap<String,Driver> drivers=new HashMap<>();
    private ArrayList<Customer> customersList=new ArrayList<>();
    private ArrayList<Driver> driversList=new ArrayList<>();
    private Scanner x;
    private Customer customer;
    private Manager manager;
    private Driver driver;



    public void loadCustomer(String filename){
        try{
            x =new Scanner(new File(filename));
            x.useDelimiter(",|\n");
            while(x.hasNext()) {
                String username = x.next();
                String password = x.next();
                String name = x.next();
                String address = x.next();
                String phoneNumber = x.next();

                customer=new Customer();
                customer.setUsername(username);
                customer.setPassword(password);
                customer.setName(name);
                customer.setAddress(address);
                customer.setPhoneNumber(phoneNumber);
                customers.put(username,customer);
                customersList.add(customer);
                System.out.println("Customer:"+customer.getUsername()+" "+customer.getPassword()+" "+customer.getName()+" "+customer.getAddress());

            }
            x.close();
        }
        catch (Exception e){
            AlertBox.display("Error in file!");
        }
    }

    public void loadManager(String filename){
        try{
            x =new Scanner(new File(filename));
            x.useDelimiter(",|\n");
            while(x.hasNext()) {
                String username = x.next();
                String password = x.next();
                String name = x.next();
                String address = x.next();
                String phoneNumber = x.next();


                manager=new Manager();
                manager.setUsername(username);
                manager.setPassword(password);
                manager.setName(name);
                manager.setAddress(address);
                manager.setPhoneNumber(phoneNumber);
                managers.put(username,manager);
                System.out.println("Manager:"+manager.getUsername()+" "+manager.getPassword()+" "+manager.getName()+" "+manager.getAddress());
            }
            x.close();
        }
        catch (Exception e){
            AlertBox.display("Error in file!");
        }
    }

    public void loadDriver(String filename){
        try{
            x =new Scanner(new File(filename));
            x.useDelimiter(",|\n");
            while(x.hasNext()) {
                String username = x.next();
                String password = x.next();
                String name = x.next();
                String address = x.next();
                String phoneNumber = x.next();



                driver = new Driver();
                driver.setUsername(username);
                driver.setPassword(password);
                driver.setName(name);
                driver.setAddress(address);
                driver.setPhoneNumber(phoneNumber);
                drivers.put(username, driver);
                driversList.add(driver);
                System.out.println("Driver:"+driver.getUsername() + " " + driver.getPassword() + " " + driver.getName() + " " + driver.getAddress());

            }
            x.close();
        }
        catch (Exception e){
            AlertBox.display("Error in file!");
        }
    }



    public HashMap<String, Customer> getCustomers() {
        return customers;
    }

    public HashMap<String, Manager> getManagers() {
        return managers;
    }

    public HashMap<String, Driver> getDrivers(){return drivers;}

    public ArrayList<Customer> getCustomersList() {
        return customersList;
    }

    public ArrayList<Driver> getDriversList() {
        return driversList;
    }

    public Customer getCustomer(String username) {
        customer=customers.get(username);
        return customer;
    }

    public Manager getManager(String username) {
        manager=managers.get(username);
        return manager;
    }

    public Driver getDriver(String username) {
        driver=drivers.get(username);
        return driver;
    }


}
