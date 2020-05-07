import java.util.HashMap;

public class AccountValidation {
    private HashMap<String,Customer> customers=new HashMap<>();
    private HashMap<String,Manager> managers=new HashMap<>();
    private HashMap<String,Driver> drivers=new HashMap<>();



    public void setCustomers(HashMap<String, Customer> customers) {
        this.customers = customers;
    }

    public void setManagers(HashMap<String, Manager> managers) {
        this.managers = managers;
    }

    public void setDrivers(HashMap<String, Driver> drivers) {
        this.drivers = drivers;
    }

    public boolean customerExist(String username){
        if(customers.containsKey(username))
            return true;
        else return false;
    }

    public boolean managerExist(String username){
        if(managers.containsKey(username))
            return true;
        else return false;
    }

    public boolean driverExist(String username){
        if(drivers.containsKey(username))
            return true;
        else return false;
    }

    public boolean authenticationCustomer(String username,String password){
        if(customerExist(username)){
            if(customers.get(username).getPassword().equals(password)){
                return true;
            }
            else{
                AlertBox.display("Incorrect username or password!");
                return false;
            }
        }

        else {
            AlertBox.display("Account not found!");
            return false;
        }
    }

    public boolean authenticationManager(String username,String password){
        if(managerExist(username)){
            if(managers.get(username).getPassword().equals(password)){
                return true;
            }
            else{
                AlertBox.display("Incorrect username or password!");
                return false;
            }
        }

        else {
            AlertBox.display("Account not found!");
            return false;
        }
    }

    public boolean authenticationDriver(String username,String password){
        if(driverExist(username)){
            if(drivers.get(username).getPassword().equals(password)){
                return true;
            }
            else{
                AlertBox.display("Incorrect username or password!");
                return false;
            }
        }

        else {
            AlertBox.display("Account not found!");
            return false;
        }
    }
}
