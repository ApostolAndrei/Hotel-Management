public class RoyalClient extends Client {

    String preffered_meniu;
    String time_to_eat;
    String function;

    public RoyalClient(String full_name, String country, Reservation rezervation, String preffered_meniu, String time_to_eat, String function) {
        super(full_name, country, rezervation);
        this.preffered_meniu = preffered_meniu;
        this.time_to_eat = time_to_eat;
        this.function = function;
    }

    public String getPreffered_meniu() {
        return preffered_meniu;
    }

    public String getTime_to_eat() {
        return time_to_eat;
    }

    public String getFunction() {
        return function;
    }

    public String print()
    {
        return super.print() + ". He/She preffers " + preffered_meniu + " at the timeframe : "
                + time_to_eat + " *** Function : " + function + " ***";
    }

}
