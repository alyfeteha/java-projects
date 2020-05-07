import java.util.ArrayList;

public class Driver extends User implements UserBehavior{
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

    public ArrayList<Trip> getTrips() {
        return trips;
    }

    public void setTrips(ArrayList<Trip> trips) {
        this.trips = trips;
    }

    public void addTrip(Trip trip){
        trips.add(trip);
    }

    @Override
    public boolean validate(AccountValidation accountValidation) {
        if(accountValidation.authenticationDriver(this.getUsername(),this.getPassword()))
            return true;
        else return false;
    }

    @Override
    public void viewTrips() {
        assignFiles=new AssignFiles();
        assignFiles.loadDriverFiles();
        this.setTrips(assignFiles.getDriverTrips(this.getUsername()));
        tripsView=new TripsView();
        if(trips==null)
            AlertBox.display("No assigned trips");
        else
            tripsView.displayTrips(trips);


    }
}
