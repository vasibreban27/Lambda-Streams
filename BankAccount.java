package utcn;

public abstract class BankAccount {
    abstract void calculateInterest();
}

class SavingsAccount extends BankAccount {
    private double balance;
    SavingsAccount(double balance) {
        this.balance = balance;
    }
    public void calculateInterest() {
        this.balance = balance * 0.05;
    }
}

class CheckingAccount extends BankAccount {
    private double balance;
    CheckingAccount(double balance) {
        this.balance = balance;
    }
    public void calculateInterest() {
        this.balance = balance * 0.15;
    }
}