public class Employee extends Human {

    private int id;
    private int salary;
    private int freedays;
    private int benefic_actions;
    static int count=1;
    static int starting_salary = 700;


    public Employee(){super();}

    public Employee(String name, int salary, int freedays , int actions) {
        super(name);
        this.salary = salary;
        this.freedays = freedays;
        this.benefic_actions = actions;
        this.id = count++;

    }

    public String getName() {
        return super.getName();
    }

    public int getSalary() {
        return salary;
    }

    public int getFreedays() {
        return freedays;
    }

    public int getId()
    {
        return id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBenefic_actions(){return id;}

    public String print()
    {
       return id + "." + super.getName()  + " Salary: " + salary + ", Free Days left: "
               + freedays +  " Benefic actions : " + benefic_actions ;
    }

}
