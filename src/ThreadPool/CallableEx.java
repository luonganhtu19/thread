package ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableEx implements Callable<Integer> {

    private int num;
    private Random ran;

    public CallableEx(int num) {
        this.num = num;
        this.ran = new Random();
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(ran.nextInt(10)*1000);
        int result = num*num;
        System.out.println("Complete "+ num);
        return result;
    }
}
class Main{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // create a list
        List<Future<Integer>> list = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<Integer> callable;
        Future<Integer> future;
        for (int i = 0; i < 5; i++) {
            callable = new CallableEx(i);
            future =executorService.submit(callable);

        }
        executorService.shutdown();


        //InvokeAny
        ExecutorService executorInvoke = Executors.newFixedThreadPool(5);
        List<Callable<Integer>> callables = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            callables.add(new CallableEx(i));
        }
        Integer result = executorInvoke.invokeAny(callables);
        System.out.println(result+"-----------------49");

        executorInvoke.shutdown();
        System.out.println("Fis");


        //InvokeAll
         ExecutorService executorInvokeAll = Executors.newFixedThreadPool(5);

         List<Callable<Integer>> callableIn = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            callableIn.add(new CallableEx(i));
        }
        List<Future<Integer>> futures = executorInvokeAll.invokeAll(callableIn);
        Integer sum =0;
        for (Future<Integer> item:futures) {
            sum+=item.get();
        }
        System.out.println("Sum all = " + sum);

        executorInvokeAll.shutdown();
        System.out.println("Finished all threads ");



    //using cancel
    ExecutorService executorServiceCa = Executors.newFixedThreadPool(5);
    long startTime = System.currentTimeMillis();
    Future<Integer> futureCancel = executorServiceCa.submit(new CallableEx(1));
    while (!futureCancel.isDone()){
        System.out.println("Task is still working----8-----------0");
        Thread.sleep(200);
        long workingTime = (System.currentTimeMillis() -startTime);
        if (TimeUnit.SECONDS.toSeconds(workingTime) > 1000) {
            futureCancel.cancel(true);
        }
        executorServiceCa.shutdown();

        if(!futureCancel.isCancelled()){
            System.out.println("Task completed! Retrieving the result");
            System.out.println("Result = " + futureCancel.get());
        }else {
            System.out.println("Task was cancelled");
        }
        System.out.println("It will throw exception form here");
        System.out.println("Result = " + futureCancel.get());
    }
    }
}
