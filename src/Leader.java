public class Leader  extends Human {


    private int hire_year;
    private int salary;


    public Leader(String name, int hire_year, int salary) {
        super(name);
        this.hire_year = hire_year;
        this.salary = salary;
    }

    public String getName() {
        return super.getName();
    }

    public int getHire_year() {
        return hire_year;
    }

    public int getSalary() {
        return salary;
    }

    public String print()
    {
        return super.getName() + " became a leader in " + hire_year
                + " and his/her salary is " + salary;
    }


    }

