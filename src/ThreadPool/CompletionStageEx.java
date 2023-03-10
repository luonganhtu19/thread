package ThreadPool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletionStageEx {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        System.out.println("Manually complete");
        completableFuture.complete(computeSomething());
        System.out.print("Get the result: ");
        String result = completableFuture.get();
        System.out.println(result);
    }

    public static String computeSomething(){
        System.out.println("Computing......");
        try {
            Thread.sleep(3000);
            System.out.println("Compute completed ........");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Future's result";
    }
}
