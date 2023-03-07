package DeadLockEx;

public class DeadLockEx {
    public static void main(String[] args) {

        final String resource1 = " Tech";

        final String resource2 = "Java Tutorial";

        Thread t1 = new Thread() {

            public void run() {
                synchronized(resource1) {
                    System.out.println("Thread 1: Locked resource1");
                    try {
                        Thread.sleep(100);
                    }
                    catch(Exception e) {}
                    synchronized(resource2) {
                        System.out.println("Thread 1: Locked resource2");
                    }
                }
            }
        };

        Thread t2 = new Thread() {

            public void run() {
                synchronized(resource1) {
                    System.out.println("Thread 2: Locked resource1");
                    try {
                        Thread.sleep(100);
                    } catch(Exception e) {}
                    synchronized(resource2) {
                        System.out.println("Thread 2: Locked resource2");
                    }
                }
            }

        };
        t1.start();
        t2.start();
    }
}
