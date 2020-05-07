import java.util.ArrayList;

public class Customer extends User implements UserBehavior{
    private AssignFiles assignFiles;
    private TripsView tripsView;
    private ArrayList<Trip> trips=new ArrayList<>();
    private int tripsIndex=0;

    public int getTripsIndex() {
        return tripsIndex++;
    }

    public void setTripIndex(){
        if(tripsIndex > trips.size())
            this.tripsIndex=0;
    }

    public void addTrip(Trip trip){
        trips.add(trip);
    }




    public boolean reserveTrip(String id){
        TripsFile tripsFile=new TripsFile();
        tripsFile.loadTrips();
        if(id.isEmpty()){
            AlertBox.display("Please enter trip id");
            return false;
        }
        else if(!checkTripExist(id)){
            AlertBox.display("Invalid Trip id");
        }
        else if(bookedTrip(id)){
            AlertBox.display("Trip already booked!");
            return false;
        }

        else {

               ConfirmationBox confirmationBox=new ConfirmationBox();
                confirmationBox.display("Are you sure you want to book this trip?");
                if (confirmationBox.getResult()) {
                    assignFiles=new AssignFiles();
                    assignFiles.loadCustomerFiles();
                    Trip trip=tripsFile.getTrip(id);
                    assignFiles.addTrip(this.getUsername(),trip);
                    return true;
                }
                else return false;

//            else {
//                AlertBox.displayTrips("Trip Unavailable");
//                return false;
//            }

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


    public ArrayList<Trip> getTrips() {
        return trips;
    }

    public void setTrips(ArrayList<Trip> trips) {
        this.trips = trips;
    }

    @Override
    public boolean validate(AccountValidation accountValidation) {
        if(accountValidation.authenticationCustomer(this.getUsername(),this.getPassword()))
            return true;
        else return false;
    }

    //Check if trip already booked
    public boolean bookedTrip(String id){
        assignFiles=new AssignFiles();
        assignFiles.loadCustomerFiles();
        this.setTrips(assignFiles.getCustomerTrips(this.getUsername()));
        if(this.getTrips()!=null) {
            for (int i = 0; i < this.getTrips().size(); i++) {
                if (this.getTrips().get(i).getTripID().equals(id))
                    return true;
            }
        }
        return false;
    }

    //View reserved trips
    @Override
    public void viewTrips() {
        assignFiles=new AssignFiles();
        assignFiles.loadCustomerFiles();
        this.setTrips(assignFiles.getCustomerTrips(this.getUsername()));
        tripsView=new TripsView();
        if(trips==null)
            AlertBox.display("No reserved trips");
        else
            tripsView.displayTrips(trips);


    }

    public void viewAllTrips(){
        tripsView=new TripsView();
        TripsFile tripsFile=new TripsFile();
        tripsFile.loadTrips();
        tripsView.displayTrips(tripsFile.getTrips());
    }

    public boolean cancelTrip(String id){
        if(id.isEmpty()){
            AlertBox.display("Please enter trip id");
            return false;
        }
        else if(bookedTrip(id)){
            ConfirmationBox confirmationBox=new ConfirmationBox();
            confirmationBox.display("Are you sure you want to book this trip?");
            if (confirmationBox.getResult()) {
                assignFiles=new AssignFiles();
                assignFiles.loadCustomerFiles();
                assignFiles.cancelCustomerTrip(this.getUsername(),id);

                return true;
            }
            else return false;
        }

        else {
            AlertBox.display("Trip not available!");
            return false;
        }
    }



    public boolean checkAvailability(String tripID){
        TripsFile tripsFile=new TripsFile();
        tripsFile.loadTrips();
        ArrayList<Trip> trips=tripsFile.getTrips();
        for(int i=0;i<trips.size();i++){
            Trip trip=trips.get(i);
            if(trip.getTripID().equals(tripID)){
                System.out.println(trip.getVehicle().getAvailableSeats());
                if(trip.getVehicle().isAvailable())
                    return true;
                else return false;
            }
        }
        return false;
    }




}
