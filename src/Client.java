import javax.swing.*;

public class Client extends Human {

    private int id ;
    private String country;
    private Reservation rezervation;
    static int count=1;

    public Client( String full_name, String country, Reservation rezervation) {

        super(full_name);
        this.id = count++;
        this.country = country;
        this.rezervation = rezervation;
    }

    public String print()
    {
        return this.id +". " +  super.getName() +
                            " from " + this.country + " has booked " + rezervation.print();
    }

    public int getId() {
        return id;
    }

    public String getFull_name() {
        return super.getName();
    }

    public String getCountry() {
        return country;
    }

    public Reservation getRezervation() {
        return rezervation;
    }

    public static int getCount() {
        return count;
    }
}
