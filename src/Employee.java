public class Employee {

    private String name;
    private int id;
    private int salary;
    private int freedays;
    private int benefic_actions;
    static int count=1;
    static int starting_salary = 700;


    public Employee(){}

    public Employee(String name, int salary, int freedays , int actions) {
        this.name = name;
        this.salary = salary;
        this.freedays = freedays;
        this.benefic_actions = actions;
        this.id = count++;

    }

    public String getName() {
        return name;
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
    String print()
    {
       return id + "." + name + " Salary: " + salary + ", Free Days left: " + freedays +  " Benefic actions : " + benefic_actions ;
    }

}
