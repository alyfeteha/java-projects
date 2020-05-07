import java.util.ArrayList;

public class Manager extends User implements UserBehavior{
    private TripsFile tripsFile;
    private TripsView tripsView;
    private AssignFiles assignFiles;


    @Override
    public boolean validate(AccountValidation accountValidation) {
        if(accountValidation.authenticationManager(this.getUsername(),this.getPassword()))
            return true;
        else return false;
    }

    @Override
    public void viewTrips() {
        tripsView=new TripsView();
        tripsFile=new TripsFile();
        tripsFile.loadTrips();
        tripsView.displayTrips(tripsFile.getTrips());
    }

    public void addTrip(Trip trip){
        tripsFile=new TripsFile();
        tripsFile.loadTrips();
        tripsFile.add(trip);
    }

    public boolean removeTrip(String id){
        tripsFile=new TripsFile();
        tripsFile.loadTrips();
        Boolean result=tripsFile.delete(id);
//        assignFiles=new AssignFiles();
//        assignFiles.loadCustomerFiles();
//        //assignFiles.loadDriverFiles();
//        assignFiles.cancelCustomerTrip(id);
        return result;
    }

    public void viewDrivers(){
        LoadInfo loadInfo=new LoadInfo();
        loadInfo.loadDriver("DriversInfo.txt");
        tripsView=new TripsView();
        tripsView.displayDrivers(loadInfo.getDriversList());
    }


    public boolean assignDrivers(String id, String username){
        tripsFile=new TripsFile();
        tripsFile.loadTrips();
        if(id.isEmpty() || username.isEmpty()){
            AlertBox.display("Please fill fields");
        }
        else if(!checkDriverExist(username)){
            AlertBox.display("Driver doesn't exist");
        }
        else if(!checkTripExist(id)){
            AlertBox.display("Trip doesn't Exist");
        }
        else if(assignedDriver(username,id)){
            AlertBox.display("Trip already assigned");
        }
        else {
            assignFiles=new AssignFiles();
            assignFiles.loadDriverFiles();
            Trip trip=tripsFile.getTrip(id);
            assignFiles.addDriver(username,trip);
            return true;
        }
        return false;
    }

    public boolean checkDriverExist(String username){
        LoadInfo loadInfo=new LoadInfo();
        loadInfo.loadDriver("DriversInfo.txt");
        ArrayList<Driver> drivers=loadInfo.getDriversList();
        for(int i=0;i<drivers.size();i++){
            if(drivers.get(i).getUsername().equals(username))
                return true;
        }
        return false;
    }

    public boolean checkTripExist(String id){
        TripsFile tripsFile=new TripsFile();
        tripsFile.loadTrips();
        ArrayList<Trip> trips=tripsFile.getTrips();
        for(int i=0;i<trips.size();i++){
            if(trips.get(i).getTripID().equals(id))
                return true;
        }
        return false;
    }

    public boolean assignedDriver(String username,String id){
        assignFiles=new AssignFiles();
        assignFiles.loadDriverFiles();
        Driver driver=assignFiles.getDriver(username);
        if(driver.getTrips()!=null) {
            for (int i = 0; i < driver.getTrips().size(); i++) {
                if (driver.getTrips().get(i).getTripID().equals(id))
                    return true;
            }
        }
        return false;
    }
}
