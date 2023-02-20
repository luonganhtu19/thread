package Other;

public class TestUdemy extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        TestUdemy t1 = new TestUdemy();
        TestUdemy t2 = new TestUdemy();
        TestUdemy t3 = new TestUdemy();
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        try {
            t1.join();
        } catch (Exception e) {
            System.out.println(e);
        }
        t3.setPriority(Thread.MAX_PRIORITY);
        t2.start();
        t3.start();
    }

}
