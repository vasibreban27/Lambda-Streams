package utcn;

import static java.lang.Thread.sleep;

public class Printer implements Runnable {
    private String name;
    public Printer(String name) {
        this.name = name;
    }
    public  void printfNumbers(){
        for(int i=1; i<=5; i++){
            System.out.print(this.name + " " + i + " ");
            try{
                sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void run(){
        printfNumbers();
    }
}

class Test3{
    public static void main(String[] args) throws InterruptedException {
        Printer printer1 = new Printer("A");
        Printer printer2 = new Printer("B");
        Thread thread1 = new Thread(printer1);
        Thread thread2 = new Thread(printer2);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

    }
}