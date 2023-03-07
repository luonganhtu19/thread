package SynchornizationEx;

public class MethodEx {
    private int counter = 0;

    public synchronized void increment(){
        counter ++;
    }
    public synchronized int getCounter(){
        return counter;
    }
}
