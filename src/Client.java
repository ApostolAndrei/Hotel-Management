public class Client {

    private int id ;
    private String full_name;
    private String country;
    private Reservation rezervation;
    static int count=1;

    public Client( String full_name, String country, Reservation rezervation) {
        this.id = count++;
        this.full_name = full_name;
        this.country = country;
        this.rezervation = rezervation;
    }

    public String print()
    {
        return this.id +". " +  this.full_name +
                            " from " + this.country + " has booked "+ rezervation.print();
    }

    public int getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
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
