package utcn;

public abstract class Employee {
    private int id;
    private String name;
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    abstract double calculateSalary();

    public void displayEmployee(){
        System.out.println("Employee ID: " + id + " Name: " + name);
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(int id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }
    public double calculateSalary(){
        return monthlySalary * 12;
    }
}

class PartTimeEmployee extends Employee{
    private double hourlyRate;
    private double hoursWorked;
    public PartTimeEmployee(int id, String name, double hourlyRate, double hoursWorked) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    public double calculateSalary(){
        return hourlyRate * hoursWorked * 12;
    }
}

class Test2{
    public static void main(String[] args) {
        FullTimeEmployee employee1 = new FullTimeEmployee(1,"Alex",2700.50);
        PartTimeEmployee employee2 = new PartTimeEmployee(2,"John",12,200);
        System.out.println("First employee salary(per year) : "+employee1.calculateSalary());
        System.out.println("Second employee salary(per year) : "+employee2.calculateSalary());
    }

}
