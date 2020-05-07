import static java.lang.Integer.parseInt;

public class MiniBus extends Vehicle {
    private final String name="Minibus";
    private String availableSeats="12";


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
