package ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
    public static void main(String[] args) {
        // create a list
        List<Future<Integer>> list = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<Integer> callable;
        Future<Integer> future;
        for (int i = 0; i < 5; i++) {
            callable = new CallableEx(i);
            future =executorService.submit(callable);

        }
    }
}
