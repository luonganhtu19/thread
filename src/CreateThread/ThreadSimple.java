package CreateThread;

public class ThreadSimple extends Thread {
    public void run(){
        System.out.println(Thread.currentThread().getName()+ " is running...");
    }

    public static void main(String[] args) {
        ThreadSimple threadSimple = new ThreadSimple();
        threadSimple.setName("Simple thread");
        threadSimple.start();
    }
}
