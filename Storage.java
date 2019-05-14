package Problem;

import java.sql.Connection;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br>
 * 〈生产者消费者模式〉
 *
 * @author Chenpeng
 * @create 2019/4/17
 * @since 1.0.0
 */
public class Storage {

    private static final int SIZE=100;
    private LinkedList<Object> linkedList=new LinkedList<>();
    private final Lock lock=new ReentrantLock();
    private final Condition full=lock.newCondition();
    private final Condition empty=lock.newCondition();

    public void produce(){

        lock.lock();
        while(linkedList.size()==SIZE) {
            try {
                full.await();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        linkedList.add(new Object());
        empty.signalAll();
        lock.unlock();

    }

    public void consume(){
        lock.lock();
        while(linkedList.size()==0) {
            try {
                empty.await();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        linkedList.remove();
        full.signalAll();
        lock.unlock();
    }

    public static void main(String[] args) {

    }
}
