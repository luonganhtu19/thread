package CreateThread;

public class RunnableSimple implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread "+Thread.currentThread().getName()+" is running......");
    }

    public static void main(String[] args) {
        RunnableSimple runnable= new RunnableSimple();
        Thread t1 = new Thread(runnable);
        t1.setName("runnableSimple");
        t1.start();
    }
}
