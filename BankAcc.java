package utcn;

import static java.lang.Thread.sleep;

public class BankAcc implements Runnable {
    private double balance = 1000;

    public synchronized void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposit amount : " + amount + " Current balance : " + balance);
    }

    public synchronized void withdraw(double amount) {
        if(balance >= amount) {
            balance = balance - amount;
            System.out.println("Withdraw amount : " + amount + " Current balance : " + balance);
        }else{
            System.out.println("No enough money");
        }
    }

    public void run(){
        for(int i = 0; i < 5; i++) {
            if(Math.random() < 0.5) {
                deposit(100);
            }else{
                withdraw(70);
            }
            try{
                sleep(50);
            }catch(InterruptedException e){}
        }
    }
}

class BankTest{
    public static void main(String[] args) {
        BankAcc acc = new BankAcc();
        Thread t1 = new Thread(acc);
        Thread t2 = new Thread(acc);
        t1.start();
        t2.start();
    }
}
