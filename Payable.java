package utcn;

public interface Payable {
    void calculatePay();
}

class SalariedEmployee implements Payable {
    private double salary;
    public SalariedEmployee(double salary) {
        this.salary = salary;
    }

    public void calculatePay() {
        System.out.println("Salary per month: " + salary);
    }
}

class HourlyEmployee implements Payable {
    private double hourlySalary;
    public HourlyEmployee(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
    public void calculatePay() {
        System.out.println("Salary: " + (hourlySalary*8)*30);
    }
}

class Test{
    public static void main(String[] args) {

        SalariedEmployee salariedEmployee = new SalariedEmployee(3000);
        HourlyEmployee hourlyEmployee = new HourlyEmployee(10);
        salariedEmployee.calculatePay();
        hourlyEmployee.calculatePay();
    }
}