package otherSynchornizationEx;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicEx {
    public static void main(String[] args) throws InterruptedException {
        final Counter counter= new Counter();

        // tao ra thread
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        counter.increment();
                    }
                }
            });
            threads[i].start();
        }
        for (int j = 0; j < threads.length; j++) {
            threads[j].join();
        }

        System.out.println("in ra gía trị counter"+ counter.getCount());
    }
}

class Counter{
    private AtomicInteger count = new AtomicInteger(0);

    public void increment(){
        count.incrementAndGet();
    }
    public int getCount(){
        return count.get();
    }
}
