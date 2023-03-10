package SynchronizationDemo;

public class SynchronousBlock implements Runnable{
    private int balance;
    public  int getBalance() {
        return balance;
    }
    public  void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +Thread.currentThread().getState());
            makeWithdrawal(75);
        if (balance<75){
            System.out.println("Money overdrawn!!");
        }
    }

    private void makeWithdrawal(int amount){
        System.out.println(Thread.currentThread().getName() +Thread.currentThread().getState());
        synchronized (this) {
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + "is about to withdraw...");
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + "has withdraw...." + amount);
                System.out.println(Thread.currentThread().getName() + Thread.currentThread().getState());
            } else {
                System.out.println("Sorry, not enough balance for " + Thread.currentThread().getName());
            }
        }
    }
}
