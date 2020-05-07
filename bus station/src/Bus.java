import static java.lang.Integer.parseInt;

public class Bus extends Vehicle {
    private final String name="Bus";
    private String availableSeats="24";

    public String getName() {
        return name;
    }

    public void setAvailableSeats(String  availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public void reserveSeat() {
        int x=parseInt(getAvailableSeats());
        if(x!=0)
            x--;
        String seat=Integer.toString(x);
        setAvailableSeats(seat);
    }


    public String getAvailableSeats() {
        return availableSeats;
    }

    @Override
    public boolean isAvailable() {
        int x=parseInt(getAvailableSeats());
        if(x>0)
            return true;
        else return false;
    }





}
