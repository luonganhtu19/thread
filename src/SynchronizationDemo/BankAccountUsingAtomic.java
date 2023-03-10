package SynchronizationDemo;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccountUsingAtomic implements Runnable {
    private AtomicInteger balance= new AtomicInteger(100);


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +Thread.currentThread().getState());
        makeWithdrawal(75);
        if (balance.get()<75){
            System.out.println("Money overdrawn!!"+ balance);
        }
    }

    private void makeWithdrawal(int amount){
        System.out.println(Thread.currentThread().getName() +Thread.currentThread().getState());

        if (balance.get()>=amount){
            System.out.println(Thread.currentThread().getName() +"is about to withdraw...");
            balance.getAndAdd(-amount);
            System.out.println(Thread.currentThread().getName()+ "has withdraw...." + amount);
        }else {
            System.out.println("Sorry, not enough balance for " + Thread.currentThread().getName());
        }
    }
}

