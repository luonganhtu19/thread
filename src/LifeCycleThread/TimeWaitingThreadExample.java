package LifeCycleThread;

public class TimeWaitingThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread timeWaitingThread = new Thread(() -> {
            System.out.println("thread state: " +Thread.currentThread().getState()+"6");
            System.out.println("Thread is running............");
            try {
                System.out.println("thread state: " +Thread.currentThread().getState()+ " before sleep");
                Thread.sleep(7000);
                System.out.println("thread state: " +Thread.currentThread().getState()+" after sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread is running again...............");
        });
        timeWaitingThread.start();
        System.out.println("State thread after starting: "+ timeWaitingThread.getState()+"----18");
        // get state time waiting of thread
        Thread.sleep(5000);
        System.out.println("State thread after starting: "+ timeWaitingThread.getState()+"----21");
        timeWaitingThread.interrupt();
        Thread.sleep(1000);
        System.out.println("State thread after starting: "+ timeWaitingThread.getState()+"----24");

    }


}
