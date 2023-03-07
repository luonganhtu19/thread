package LifeCycleThread;

public class TimeWaitingThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread timeWaitingThread = new Thread(() -> {
            System.out.println("thread state: " +Thread.currentThread().getState());
            System.out.println("Thread is running............");
            try {
                System.out.println("thread state: " +Thread.currentThread().getState()+ "before sleep");
                Thread.sleep(50000);
                System.out.println("thread state: " +Thread.currentThread().getState()+"after sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread is running again...............");
        });
        timeWaitingThread.start();

        // get state time waiting of thread
        Thread.sleep(1000);
        Thread.State state = timeWaitingThread.getState();
        System.out.println("State thread after starting: "+ state);
    }


}
