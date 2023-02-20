package Demo;

import java.util.concurrent.TimeUnit;

public class MyFirstThread {
    public static int key = 3;
    static Thread thread;
    public static void main(String[] args)  {
        Task task = new Task();
        thread = new Thread(task);
        thread.start();

        System.out.println("sleep3.........."+key+ thread.getState());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(thread.getState());
            thread.start();
        }

        System.out.println("Inside main ....."+ Thread.currentThread().getName()+"....."+key);
    }
}
class  Task implements Runnable{

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println("inside run........." +Thread.currentThread().getName()+"........"+MyFirstThread.key +MyFirstThread.thread.getState());
        go();
    }
    private  void go(){
        MyFirstThread.key=1;
        System.out.println("inside more ...." + Thread.currentThread().getName()+"......"+MyFirstThread.key+MyFirstThread.thread.getState());
    }
}
