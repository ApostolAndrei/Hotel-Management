import java.io.IOException;
import java.util.*;
import java.io.File;

public class Management {
    protected List<Employee> employees = new ArrayList<Employee>();
    protected List<Candidate> candidates = new ArrayList<Candidate>();
    protected List<Client> clients = new ArrayList<Client>();
    protected List<Leader> leaders = new ArrayList<Leader>();
    protected List<RoyalClient> royals = new ArrayList<RoyalClient>();


    public Management() throws IOException {

        File clients = new File("C:\\Users\\Andrei\\Desktop\\ANUL 2.2\\PAO\\Tema\\src\\clients.txt");
        Scanner inClient = new Scanner(clients);
        while (inClient.hasNextLine()) {
            String temp = inClient.nextLine();
            String[] data = temp.split(",");
            this.addClient(new Client(data[0], data[1], new Reservation(Integer.valueOf(data[2]), Integer.valueOf(data[3]), Integer.valueOf(data[4]))));
        }


        File candidates = new File("C:\\Users\\Andrei\\Desktop\\ANUL 2.2\\PAO\\Tema\\src\\candidates.txt");
        Scanner inCandidates = new Scanner(candidates);
        while (inCandidates.hasNextLine()) {
            String temp = inCandidates.nextLine();
            String[] data = temp.split(",");
            this.addCandidates(new Candidate(data[0], Integer.valueOf(data[1]), data[2], Integer.valueOf(data[3])));
        }

        File employees = new File("C:\\Users\\Andrei\\Desktop\\ANUL 2.2\\PAO\\Tema\\src\\employees.txt");
        Scanner inEmployees = new Scanner(employees);
        while (inEmployees.hasNextLine()) {
            String temp = inEmployees.nextLine();
            String[] data = temp.split(",");
            this.addEmployees(new Employee(data[0], Integer.valueOf(data[1]), Integer.valueOf(data[2]), Integer.valueOf(data[3])));
        }

        File leaders = new File("C:\\Users\\Andrei\\Desktop\\ANUL 2.2\\PAO\\Tema\\src\\leaders.txt");
        Scanner inLeaders = new Scanner(leaders);
        while (inLeaders.hasNextLine()) {
            String temp = inLeaders.nextLine();
            String[] data = temp.split(",");
            this.addLeader(new Leader(data[0], Integer.valueOf(data[1]), Integer.valueOf(data[2])));
        }

        File royals = new File("C:\\Users\\Andrei\\Desktop\\ANUL 2.2\\PAO\\Tema\\src\\Royals.txt");
        Scanner inRoyal = new Scanner(royals);
        while (inRoyal.hasNextLine()) {
            String temp = inRoyal.nextLine();
            String[] data = temp.split(",");
            this.addRoyal(new RoyalClient(data[0], data[1], new Reservation(Integer.valueOf(data[2]), Integer.valueOf(data[3]), Integer.valueOf(data[4])),data[5],data[6],data[7]));
        }


    }


    void addClient(Client c) {
        this.clients.add(c);
    }

    void addEmployees(Employee e) {
        this.employees.add(e);
    }

    void addCandidates(Candidate c) {
        this.candidates.add(c);
    }

    void addRoyal(RoyalClient r) {this.royals.add(r);}

    void addLeader(Leader l) { this.leaders.add(l);}



    void listAllClients() {
        for (Client c : this.clients)
            System.out.println(c.print());
    }

    void listAllRoyalClients() {
        for (RoyalClient c : this.royals)
            System.out.println(c.print());
    }

    void listAllCandidates() {
        for (Candidate c : this.candidates)
            System.out.println(c.print());
    }

    void listAllEmployees() {
        for (Employee c : this.employees)
            System.out.println(c.print());
    }

    void listAllLeaders(){
        for (Leader c : this.leaders)
            System.out.println(c.print());
    }

    int calculateProfit() {
        int salaries = 0;
        int earnings = 0;

        for (Employee e : this.employees)
            salaries += e.getSalary();

        for (Client c : this.clients)
            earnings += c.getRezervation().getTotal_price();

        return earnings - salaries;
    }


    String getBestEmployee() {
        Employee best = new Employee();

        for (Employee man : this.employees) {

            if (best.getBenefic_actions() < man.getBenefic_actions())
                best = man;
        }
        return " Employee of the month: " + best.getName();
    }


    void searchClient(String name) {

        for (Client c : this.clients) {
            if (name.equals(c.getFull_name()))
                System.out.println(c.print());
        }
    }


    void increaseSalary(String name, int bonus) {
        for (Employee e : this.employees)
            if (e.getName().equals(name))
                {
                    e.setSalary(e.getSalary() + bonus);
                    System.out.println("New salary: " + e.getSalary());
                return;
                 }
    }

    void decreaseSalary(String name, int bonus) {
        for (Employee e : this.employees)
            if (e.getName().equals(name)) {
                e.setSalary(e.getSalary() - bonus);
                System.out.println("New salary: " + e.getSalary());
                return;
            }
    }

    void hireCandidate(String name) {
        for (Candidate c : this.candidates) {
            if (c.getName().equals(name)) {
                candidates.remove(c);
                this.addEmployees(new Employee(c.getName(), Employee.starting_salary , 27, 0));
                System.out.println("Hired");
                return;
            }
        }
    }

    void promote(String name) {
        for ( Employee e : this.employees) {
            if (e.getName().equals(name)) {
                employees.remove(e);
                this.addLeader(new Leader(e.getName(), Calendar.getInstance().get(Calendar.YEAR), e.getSalary()+1000));
                System.out.println("Promoted");
                return;
            }
        }
    }

    void sortCandidatesByExp()
    {
        Collections.sort(candidates, new Comparator<Candidate>() {
            public int compare(Candidate c1, Candidate c2) {
                return Float.compare(c1.getYears_of_experience(), c2.getYears_of_experience());
            }
        });
        for (Candidate c : candidates)
            System.out.println(c.print());
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
                System.out.println("Type the name of the candidate : ");
                hireCandidate(s2.nextLine());
                System.out.println("Press 0 to display the menu again");
                break;

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
                increaseSalary(s5.nextLine(), s5.nextInt());
                System.out.println("Press 0 to display the menu again");
                break;


            case 11:

                Scanner s6 = new Scanner (System.in);
                System.out.println("Type the name of the employee and the amount");
                decreaseSalary(s6.nextLine(), s6.nextInt());
                System.out.println("Press 0 to display the menu again");
                break;


            case 12:
                System.out.println(calculateProfit());
                System.out.println("Press 0 to display the menu again");
                break;

            case 0:
                printMenu();
                break;

            default:
                System.out.println("You exit the menu");
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

    }
}













