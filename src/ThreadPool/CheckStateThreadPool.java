package ThreadPool;

import java.util.concurrent.*;

public class CheckStateThreadPool {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        // tao 1 runnable de thuc thi trong thread pool
        Callable task = () -> {
            System.out.println("Thread is running .....");
            try {
                Thread.sleep(1000);
                return "task is done";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return e.getMessage();
            }
        };

        // Gui Runnable to thread pool lay Future
        Future<?> future = executorService.submit(task);

        System.out.println("Thread state: "+ (future.get()));
        executorService.shutdown();

    }
}
