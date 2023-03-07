package LifeCycleThread;

public class WaitingThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread waitingThread = new Thread(()->{
            synchronized (lock){
                try {
                    System.out.println("Thread is waiting.........");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        waitingThread.start();
        Thread.sleep(1000);
        System.out.println("Waiting thread state: " +waitingThread.getState());
        synchronized (lock){
            lock.notify();
            System.out.println("thread state: " +waitingThread.getState());
        }

        waitingThread.join();
        System.out.println("thread state: " +waitingThread.getState());
    }
}
