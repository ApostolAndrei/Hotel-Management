public class Candidate {

    private String name;
    private int wanted_salary;
    private String wanted_department;
    private int years_of_experience;
    private int id;
    static int count = 0;

    public Candidate(String name, int wanted_salary, String wanted_department, int years) {
        this.name = name;
        this.wanted_salary = wanted_salary;
        this.wanted_department = wanted_department;
        this.years_of_experience = years;
        this.id = count++;
    }

    public String getName() {
        return name;
    }

    public int getWanted_salary() {
        return wanted_salary;
    }

    public String getWanted_department() {
        return wanted_department;
    }

    public int getYears_of_experience() {
        return years_of_experience;
    }

    String print() {
        return " Candidate  " + name + " has an experience "
                + years_of_experience + " years and wants to work as a "
                + wanted_department + " for a " + wanted_salary + " euro salary";
    }

}

