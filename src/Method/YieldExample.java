package Method;

public class YieldExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new YieldThread());
        Thread t2 = new Thread(new YieldThread());
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}

class YieldThread implements Runnable{
    public void run(){
        synchronized (this){
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread " +Thread.currentThread().getName()+ " is running "+i);
            System.out.println("Thread " +Thread.currentThread().getName()+ Thread.currentThread().getState() + " is running "+i);
            Thread.yield();
            System.out.println("Thread "+Thread.currentThread().getName()+" " +Thread.currentThread().getState()+ " "+ i);
        }
    }
    }
}
