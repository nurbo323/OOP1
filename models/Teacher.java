package models;

public class Teacher extends Person {
    private String subject;
    public int yearsOfExperience;
    private int salary;

    public Teacher(String name, String surname, int age, boolean isMale, String subject, int yearsOfExperience, int salary) {
        super(name, surname, age, isMale);
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }

    public void giveRaise(double percentage) {
        salary += salary * percentage / 100;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + " I teach " + subject + ".";
    }
}