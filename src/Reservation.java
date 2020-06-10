public class Reservation {

    private int number_of_rooms;
    private int number_of_days;
    private int total_price;

    public Reservation(int number_of_rooms, int number_of_days, int price) {
        this.number_of_rooms = number_of_rooms;
        this.number_of_days = number_of_days;
        this.total_price = price;
    }

    public int getNumber_of_rooms() {
        return number_of_rooms ;
    }

    public int getNumber_of_days() {
        return number_of_days;
    }

    public int getTotal_price() {
        return total_price;
    }

    String print()
    {
        return  number_of_rooms + " room(s) for "+ number_of_days
                + " days " + "at a total cost of " + total_price + " euro ";
    }
}
