package Other;

public class RaceCondition {
    public static void main(String[] args) {
        BankAccount task = new BankAccount();
        task.setBalance(100);

        Thread john = new Thread(task);
        Thread anita = new Thread(task);
        john.setName("John");
        anita.setName("Anita");

        john.start();
        anita.start();
    }
}

class BankAccount implements Runnable {
    public int balance;
    private int sum = balance+3;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
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

        makeWithdrawal(75);
        if (balance<0){
            System.out.println("Money overdrawn");
        }
    }
    private void makeWithdrawal(int amount){
        if (balance >= amount){
            System.out.println(Thread.currentThread().getName() + "is about ");
        balance -=amount;
            System.out.println(Thread.currentThread().getName()+ " has withdraw");
        }else {
            System.out.println("Sorry, not enough balance for "+ Thread.currentThread().getName());
        }
    }
}
