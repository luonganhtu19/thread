package raceCondition;

import com.sun.org.apache.bcel.internal.generic.ATHROW;

public class RaceConditionDemo {
    public static void main(String[] args) {
        BankAccount task = new BankAccount();
        task.setBalance(100);

        Thread john = new Thread(task);
        Thread anita = new Thread(task);
        john.setName("John");
        anita.setName("Anita");
        john.start();
        john.run();
        anita.start();
        anita.start();
    }
}
class BankAccount implements Runnable{
    private int balance;

    public  int getBalance() {
        return balance;
    }

    public  void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +Thread.currentThread().getState());
//        makeWithdrawal(75);
//        if (balance<75){
//            System.out.println("Money overdrawn!!");
//        }
    }
    private synchronized void makeWithdrawal(int amount){System.out.println(Thread.currentThread().getName() +Thread.currentThread().getState());
        if (balance>=amount){
            System.out.println(Thread.currentThread().getName() +"is about to withdraw...");
            balance -=amount;
            System.out.println(Thread.currentThread().getName()+ "has withdraw...." + amount);
            System.out.println(Thread.currentThread().getName() +Thread.currentThread().getState());
        }else {
            System.out.println("Sorry, not enough balance for" + Thread.currentThread().getName());
        }

    }
}
