package Other;

public class MyThread {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();

        System.out.println(".......main   "+Thread.currentThread().getId());
    }
}
class Task implements Runnable{

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
        System.out.println("Inside run ..."+Thread.currentThread().getId());
        go();
    }

    private void go(){
        System.out.println("Inside go....."+ Thread.currentThread().getId());
    }
}
