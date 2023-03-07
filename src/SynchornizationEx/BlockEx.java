package SynchornizationEx;

public class BlockEx {
    private int counter = 0;
    private Object lock = new Object();

    public void increment(){
        synchronized (lock){
            counter++;
        }
    }

    public int getCounter(){
        synchronized (lock){
            return counter;
        }
    }
}
