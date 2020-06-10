import java.io.IOException;
import java.util.*;
import java.io.File;
import java.sql.Timestamp;
import java.sql.*;


public class Management {
    protected List <Human> persons = new ArrayList<Human>();
    protected Set <Hotel> hotels = new HashSet<Hotel>();
    ReadFile fin = ReadFile.getInstance();

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());


    String url = "jdbc:mysql://localhost:3306/hotelmanag";
    String username = "root";
    String password = "";

    private static ResultSet getAllClients(Statement statement)

    {
        String query = "SELECT * FROM hotelmanag.clients";
        try{
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e);
        } return null;
    }

    private static ResultSet getAllCandidates(Statement statement)

    {
        String query = "SELECT * FROM hotelmanag.candidates";
        try{
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e);
        } return null;
    }

    private static ResultSet getAllEmployees(Statement statement)
    {
        String query = "SELECT * FROM hotelmanag.employees";
        try{
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e);
        } return null;
    }

    private static ResultSet getAllLeaders(Statement statement)
    {
        String query = "SELECT * FROM hotelmanag.leaders";
        try{
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e);
        } return null;
    }



    public Management() throws IOException {

        try(Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement()) {

            ResultSet clients = getAllClients(statement);


            while(clients.next()) {
                Client c = new Client(clients.getString("Name"),
                                      clients.getString("Country"),

                                      new Reservation(clients.getInt("NrPersons"),
                                      clients.getInt ("NrNights"),
                                      clients.getInt ("Price") ));
                this.addClient(c);
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }


        try(Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement2 = connection.createStatement()) {
            ResultSet candidates = getAllCandidates(statement2);

            while (candidates.next()) {
                Candidate cand = new Candidate(candidates.getString("CandName"),
                        candidates.getInt("WantedSalary"),
                        candidates.getString("Post"),
                        candidates.getInt("ExpYears"));

                this.addCandidates(cand);

            }
        }
            catch (SQLException e) {
            System.out.println(e);
        }

        try(Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement3 = connection.createStatement()) {
            ResultSet employees = getAllEmployees(statement3);

            while (employees.next()) {
                Employee e = new Employee(employees.getString("Name"),
                        employees.getInt("Salary"),
                        employees.getInt("FreeDays"),
                        employees.getInt("BeneficActions"));

                this.addEmployees(e);

            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }

        try(Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement4 = connection.createStatement()) {
            ResultSet leaders = getAllLeaders(statement4);

            while (leaders.next()) {
                Leader l = new Leader(leaders.getString("Name"),
                        leaders.getInt("FirstYear"),
                        leaders.getInt("Salary"));

                this.addLeader(l);

            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }


        List<String [] > royals =  fin.read( "C:\\Users\\Andrei\\Desktop\\ANUL 2.2\\PAO\\Tema\\src\\Royals.csv");
        for(String[] line : royals)
            this.addRoyal(new RoyalClient(line[0], line[1], new Reservation(Integer.valueOf(line[2]), Integer.valueOf(line[3]), Integer.valueOf(line[4])),line[5],line[6],line[7]));



        List<String [] > hotels =  fin.read( "C:\\Users\\Andrei\\Desktop\\ANUL 2.2\\PAO\\Tema\\src\\hotels.csv");
        for(String[] line : hotels)
            this.addHotel(new Hotel(line[0],Integer.valueOf(line[1])));




           CEO ceo = CEO.getInstance();


            System.out.println("\n ********** CEO : "  + ceo.getName() + " ********** \n");
            this.persons.add(ceo);
    }






    void addClient(Client c) {
        this.persons.add(c);
    }

    void addEmployees(Employee e) {
        this.persons.add(e);
    }

    void addCandidates(Candidate c) {
        this.persons.add(c);
    }

    void addRoyal(RoyalClient r) {this.persons.add(r);}

    void addLeader(Leader l) { this.persons.add(l);}

    void addHotel(Hotel h){ this.hotels.add(h); }



    void listAllClients() {

        for (Human c : this.persons)
            if (c instanceof Client)
                System.out.println(c.print());
            fin.audit();
    }

    void listAllRoyalClients() {


        for (Human c : this.persons)
            if (c instanceof RoyalClient)
                System.out.println(c.print());
        fin.audit();
    }

    void listAllCandidates() {

        for (Human c : this.persons)
            if (c instanceof Candidate)
                System.out.println(c.print());
        fin.audit();

    }

    void listAllEmployees() {



        for (Human c : this.persons)
        if (c instanceof Employee)
            System.out.println(c.print());
       fin.audit();
    }

    void listAllLeaders(){


        for (Human c : this.persons)
            if (c instanceof Leader)
                System.out.println(c.print());
        fin.audit();
    }

    void listAllHotels()
    {


        for(Hotel h : this.hotels)
            h.print();
       fin.audit();
    }

    int calculateProfit() {

       fin.audit();

        int salaries = 0;
        int earnings = 0;

        for (Human c : this.persons)
            if (c instanceof Employee)
              salaries += ((Employee)c).getSalary();

        for (Human c : this.persons)
            if (c instanceof Client)
            earnings += ((Client) c).getRezervation().getTotal_price();

        return earnings - salaries;
    }


    String getBestEmployee() {


        Human best = new Employee();
        fin.audit();


        for (Human e : this.persons) {

            if (((Employee)best).getBenefic_actions() < ((Employee)e).getBenefic_actions())
                best = e;
        }
        return " Employee of the month: " + best.getName();
    }




    void searchClient(String name) {

        fin.audit();

        for (Human c : this.persons) {
            if (name.equals(c.getName()) && c instanceof Client)
                System.out.println(c.print());
        }
    }


    void increaseSalary(Statement s , String name, int bonus) {

        fin.audit();

        String query = "UPDATE hotelmanag.employees SET Name = '" + name +"' WHERE (Salary = '"+ bonus +"');";

        try{
            s.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    void decreaseSalary(Statement s , String name, int bonus) {

       fin.audit();

        String query = "UPDATE `hotelmanag`.`employees` SET `Salary` = '" + bonus +"' WHERE (`Name` = '"+ name + "')";

        try{
            s.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    void hireCandidate(Statement s , String name) {


        fin.audit();

        String delete = "DELETE from `hotelmanag`.`candidates`  WHERE (`CandName` = '"+ name + "')";
        String insert = "INSERT into hotelmanag.employees values ("+name+" , 800 , 30 , 10)";


        try{
            s.executeUpdate(delete);
            s.executeQuery(insert);
        } catch (SQLException e) {
            System.out.println(e);
        }


    }

    void promote(String name) {

     fin.audit();

        for ( Human e : this.persons) {
            if (e.getName().equals(name) && e instanceof Employee) {
                persons.remove(e);
                this.addLeader(new Leader(e.getName(), Calendar.getInstance().get(Calendar.YEAR), ((Employee) e).getSalary()+1000));
                System.out.println("Promoted");
                return;
            }
        }
    }

    void sortCandidatesByExp()
    {
        fin.audit();

        Collections.sort(persons, new Comparator<Human>() {
            public int compare(Human h1, Human h2) {

                    if(h1 instanceof Candidate && h2 instanceof Candidate)
                    return Float.compare(((Candidate) h1).getYears_of_experience(), ((Candidate) h2).getYears_of_experience());
                    return 0;
            }
        });
        listAllCandidates();
    }


    void ChooseYourOption()
    {
        Scanner s = new Scanner(System.in);

        boolean input = true;
        printMenu();

        do{
            int option = s.nextInt();

        switch(option) {

            case 1:
                listAllClients();
                System.out.println("Press 0 to display the menu again");
                break;

            case 2:
                listAllRoyalClients();
                System.out.println("Press 0 to display the menu again");
                break;

            case 3:
                listAllEmployees();
                System.out.println("Press 0 to display the menu again");
                break;

            case 4:
                listAllLeaders();
                System.out.println("Press 0 to display the menu again");
                break;

            case 5:
                sortCandidatesByExp();
                System.out.println("Press 0 to display the menu again");
                break;

            case 6:

                Scanner s2 = new Scanner(System.in);
                try(Connection connection = DriverManager.getConnection(url, username, password);
                    Statement st3 = connection.createStatement()) {
                    hireCandidate(st3 , s2.nextLine() );    

                } catch (SQLException e) {
                    System.out.println(e);
                }


            case 7:

                Scanner s3 = new Scanner(System.in);

                System.out.println("Type the name of the client : ");
                searchClient(s3.nextLine());

                System.out.println("Press 0 to display the menu again");
                break;

            case 8:
               System.out.println(getBestEmployee());
                System.out.println("Press 0 to display the menu again");
                break;


            case 9:

                Scanner s4 = new Scanner(System.in);
                System.out.println("Type the name of the employee : ");
                promote(s4.nextLine());
                System.out.println("Press 0 to display the menu again");
                break;


            case 10:

                Scanner s5 = new Scanner(System.in);
                System.out.println("Type the name of the employee and the bonus");

                try(Connection connection = DriverManager.getConnection(url, username, password);
                    Statement st = connection.createStatement()) {
                    increaseSalary(st , s5.nextLine() , s5.nextInt() );

                } catch (SQLException e) {
                    System.out.println(e);
                }

                System.out.println("Press 0 to display the menu again");
                break;


            case 11:

                Scanner s6 = new Scanner (System.in);
                System.out.println("Type the name of the employee and the amount");

                try(Connection connection = DriverManager.getConnection(url, username, password);
                    Statement sta = connection.createStatement()) {

                    decreaseSalary(sta , s6.nextLine(), s6.nextInt());

                } catch (SQLException e) {
                    System.out.println(e);
                }

                System.out.println("Press 0 to display the menu again");
                break;


            case 12:
                System.out.println(calculateProfit());
                System.out.println("Press 0 to display the menu again");
                break;

            case 13:
                listAllHotels();
                System.out.println("Press 0 to display the menu again");
                break;

            case 0:
                printMenu();
                System.out.println(timestamp);
                break;

            default:
                System.out.println("Something went wrong");
                input = false;
                break;

        }

        } while(input);


    }

    void printMenu()
    {

        System.out.println("------------------ MENU ------------------ \n");

        System.out.println(" 1 --> Display all your clients ");
        System.out.println(" 2 --> Display royal clients");
        System.out.println(" 3 --> Display all your employees");
        System.out.println(" 4 --> Display the leading staff ");
        System.out.println(" 5 --> Display candidates sorted by experience ");
        System.out.println(" 6 --> Hire a candidate");
        System.out.println(" 7 --> Search client by name");
        System.out.println(" 8 --> Show your best employee ");
        System.out.println(" 9 --> Promote an employee");
        System.out.println(" 10 --> Increase salary of an employee ");
        System.out.println(" 11 --> Decrease salary of an employee ");
        System.out.println(" 12 --> Calculate  profit ");
        System.out.println(" 13 --> List all our hotels");

    }

}













