public class Leader {

    private String name;
    private int hire_year;
    private int salary;


    public Leader(String name, int hire_year, int salary) {
        this.name = name;
        this.hire_year = hire_year;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getHire_year() {
        return hire_year;
    }

    public int getSalary() {
        return salary;
    }

    String print()
    {
        return name + " became a leader in " + hire_year
                + " and his/her salary is " + salary;
    }


    }

