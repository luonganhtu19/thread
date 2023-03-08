package ThreadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CheckStateThreadPool {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        // tao 1 runnable de thuc thi trong thread pool
        Runnable task = () -> {
            System.out.println("Thread is running .....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Gui Runnable to thread pool lay Future
        Future<?> future = executorService.submit(task);

        System.out.println("Thread state: "+ (future.get());
        executorService.shutdown();
    }
}
