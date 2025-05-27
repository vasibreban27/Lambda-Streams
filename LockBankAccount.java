package utcn;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class LockBankAccount {
    private double balance = 1000;
    private final Lock lock = new ReentrantLock();

    public void deposit(double amount) {
        if (lock.tryLock()) {
            try {
                balance += amount;
                System.out.println("Locked deposit " + amount + ", balance=" + balance);
            } finally { lock.unlock(); }
        } else {
            System.out.println("Could not acquire lock to deposit");
        }
    }

    public void withdraw(double amount) {
        try {
            if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    if (balance >= amount) {
                        balance -= amount;
                        System.out.println("Locked withdraw " + amount + ", balance=" + balance);
                    } else {
                        System.out.println("Insufficient funds for " + amount);
                    }
                } finally { lock.unlock(); }
            } else {
                System.out.println("Timeout: could not acquire lock to withdraw");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

 class LockBankTest {
    public static void main(String[] args) {
        LockBankAccount account = new LockBankAccount();
        Runnable task = () -> {
            account.deposit(100);
            account.withdraw(50);
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start(); t2.start();
    }
}