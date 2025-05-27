package utcn;

public class Counter implements Runnable{
    private int counter = 0;

    public void run(){
        for(int i=0; i<10; i++){
            increment();
        }
    }
    public synchronized void increment(){
        counter++;
    }
    public synchronized int getCounter(){
        return counter;
    }
}

class TestSync{
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter);
        Thread t2 = new Thread(counter);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final value is for counter is :" + counter.getCounter());
    }
}
