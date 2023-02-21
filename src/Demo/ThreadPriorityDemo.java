package Demo;

public class ThreadPriorityDemo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        Thread t1= new Thread(new EmailCampaign());
        Thread t2= new Thread(new DataAggregator());

        t1.setName("EmailCampaign");
        t2.setName("DataAggregator");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);



        t1.start();
        t2.start();
        try{
            // main thread is suspend until t2 DIES
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Inside main...");

    }

    static class EmailCampaign implements Runnable{

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
            for (int i =1 ; i<= 10; i++){
                System.out.println(Thread.currentThread().getName());
                if (i==5){
                    // hint to scheduler that thread is willing to
                    //yield its current use of CPU
                    Thread.yield();
                }
            }
        }
    }
    static class DataAggregator implements Runnable{

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
            for (int i =1; i<=10;i++){
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
