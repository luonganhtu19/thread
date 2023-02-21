package Other;

public class IntrinsicLock {

}
class Person{
    private String state;
    private final Object lock= new Object();

    public String getState(){
        synchronized (lock){
            return state;
        }
    }

    public void setState(String newState){
        synchronized (lock){
            state= newState;
        }
    }
}
