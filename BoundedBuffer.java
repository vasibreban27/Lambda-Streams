package utcn;
import java.util.LinkedList;
import java.util.Queue;

public class BoundedBuffer implements Runnable {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity = 5;
    private final int maxItems;
    private final boolean produceMode;

    public BoundedBuffer(int maxItems, boolean produceMode) {
        this.maxItems = maxItems;
        this.produceMode = produceMode;
    }

    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == capacity) wait();
        queue.add(value);
        System.out.println(Thread.currentThread().getName() + " produced " + value + "; Buffer size=" + queue.size());
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) wait();
        int val = queue.remove();
        System.out.println(Thread.currentThread().getName() + " consumed " + val + "; Buffer size=" + queue.size());
        notifyAll();
        return val;
    }

    @Override
    public void run() {
        if (produceMode) {
            for (int i = 1; i <= maxItems; i++) {
                try {
                    produce(i);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        } else {
            for (int i = 1; i <= maxItems; i++) {
                try {
                    consume();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {
        int itemCount = 10;
        Thread producerThread = new Thread(new BoundedBuffer(itemCount, true), "Producer");
        Thread consumerThread = new Thread(new BoundedBuffer(itemCount, false), "Consumer");
        producerThread.start();
        consumerThread.start();
    }
}