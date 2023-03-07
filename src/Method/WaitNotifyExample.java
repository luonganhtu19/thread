package Method;

public class WaitNotifyExample {
    public static void main(String[] args) {
        ThreadEx ex = new ThreadEx();
        ex.start();

        synchronized (ex){
            System.out.println("waiting for to ex to complete" );
            try {
                System.out.println(ex.getState()+"  11");
                ex.wait();
                System.out.println(ex.getState()+"  13");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Total is: " +ex.total);
        }
        System.out.println(ex.total);
    }
}
class ThreadEx extends Thread{
    int total;
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getState());
        synchronized (this){
            for (int i =0;i<10000;i++){
                total +=i;
            }
            System.out.println(Thread.currentThread().getState()+ "..31");
            notify();
        }
    }
}
