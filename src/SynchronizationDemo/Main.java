package SynchronizationDemo;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        BankAccountProblem task = new BankAccountProblem();
//        SynchronousBlock task = new SynchronousBlock();
//        BankAccountUsingSynchronousMethod task = new BankAccountUsingSynchronousMethod();
//        BankAccountUsingSynchronousStatic task = new BankAccountUsingSynchronousStatic();
        BankAccountUsingAtomic task = new BankAccountUsingAtomic();

        Thread john = new Thread(task);
        Thread anita = new Thread(task);
        john.setName("John");
        anita.setName("Anita");
        john.start();
        anita.start();
        john.join();
        anita.join();
    }
}
