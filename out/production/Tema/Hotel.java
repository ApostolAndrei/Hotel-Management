    public class Hotel {


       private String location;
       private int profit;

        public Hotel (String location , int profit)
        {
            this.location = location;
            this.profit = profit;
        }


        public String getLocation() {
            return location;
        }

        public int getProfit() {
            return profit;
        }

        void print()
        {
            System.out.println("The hotel is located in" + this.location + " and has a profit of "  + this.profit + " euro ");
        }

      }





