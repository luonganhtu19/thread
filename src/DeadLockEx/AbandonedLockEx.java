package DeadLockEx;

import CreateThread.ThreadSimple;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AbandonedLockEx {
    private static Lock lock = new ReentrantLock();

    public void accessResource (){
        System.out.println(Thread.currentThread().getName()+" yêu cầu khóa");
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" giữ khóa");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+" mở khóa");
        }
    }
    public static void main(String[] args) {
        AbandonedLockEx ex = new AbandonedLockEx();
        ex.accessResource();

        // tiến trình phụ yêu cầu khóa, nhưng không bao giờ giải phóng
        new Thread(()-> {
            ex.accessResource();
        }).start();
    }
}
