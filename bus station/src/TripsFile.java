import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class TripsFile {
    private ArrayList<Trip> trips=new ArrayList<>();
    private Trip trip;
    private Vehicle vehicle;
    private Scanner x;



    public void loadTrips(){
        try{
            x=new Scanner(new File("TripsInfo.txt"));
            x.useDelimiter(",|\n");
            while (x.hasNext()) {
                String tripID = x.next();
                String source = x.next();
                String destination = x.next();
                String date = x.next();
                String time = x.next();
                String type = x.next();
                String stopType = x.next();
                String price = x.next();
                String vehicleType = x.next();
                String numberofSeats = x.next();


                trip = new Trip();
                trip.setTripID(tripID);
                trip.setSource(source);
                trip.setDestination(destination);
                trip.setDate(date);
                trip.setTime(time);
                trip.setType(type);
                trip.setStopType(stopType);
                trip.setPrice(price);
                if (vehicleType.equals("Bus")) {
                    //System.out.println("Bus");
                    vehicle = new Bus();
                    vehicle.setAvailableSeats(numberofSeats);
                    trip.setVehicle(vehicle);

                }
                else if(vehicleType.equals("Limousine")){
                    //System.out.println("Limo");
                    vehicle = new Limousine();
                    vehicle.setAvailableSeats(numberofSeats);
                    trip.setVehicle(vehicle);
                }

                else {
                   // System.out.println("Minibus");
                    vehicle = new MiniBus();
                    vehicle.setAvailableSeats(numberofSeats);
                    trip.setVehicle(vehicle);
                }
                trips.add(trip);
            }

            x.close();

        }
        catch (Exception e){
            System.out.println(e);
            AlertBox.display("Error in loading trip files");
        }
    }


    public void writeTrips() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("TripsInfo.txt", false));
            int i = 0;
            while (i < trips.size()) {
                System.out.println(trips.size());
                //System.out.println("writing");
                bufferedWriter.write(trips.get(i).getTripID() + ",");
                bufferedWriter.write(trips.get(i).getSource() + ",");
                bufferedWriter.write(trips.get(i).getDestination() + ",");
                bufferedWriter.write(trips.get(i).getDate() + ",");
                bufferedWriter.write(trips.get(i).getTime() + ",");
                bufferedWriter.write(trips.get(i).getType()+",");
                bufferedWriter.write(trips.get(i).getStopType() + ",");
                bufferedWriter.write(trips.get(i).getPrice() + ",");
                bufferedWriter.write(trips.get(i).getVehicle().getName() + ",");
                bufferedWriter.write(trips.get(i).getVehicle().getAvailableSeats());
                bufferedWriter.newLine();
                i++;
            }
            bufferedWriter.close();
        }catch (Exception e){
            AlertBox.display("Error in writing");
        }
    }

    public void add(Trip trip){
        trips.add(trip);
        writeTrips();
        //System.out.println("Done add");

    }

    public boolean delete(String id){
        System.out.println(trips.size());
        for(int i=0;i<trips.size();i++){
            String tripID=trips.get(i).getTripID();
            //System.out.println(id+tripID);
            if(tripID.equals(id)){
                trips.remove(i);
                writeTrips();
               // System.out.println("Done");
                return true;
            }
        }
        return false;

    }



    public Trip getTrip(String id) {

        for(int i=0;i<trips.size();i++){
            Trip trip=trips.get(i);
            String tripid=trip.getTripID();
            System.out.println(id);
            System.out.println(tripid);
            System.out.println(tripid.equals(id));
            if(id.equals(tripid)) {
                System.out.println("Found trip");
                return trip;
            }
        }
        System.out.println("trip not found");
        return null;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public ArrayList<Trip> getTrips() {
        return trips;
    }

    public void setTrips(ArrayList<Trip> trips) {
        this.trips = trips;
    }
}
