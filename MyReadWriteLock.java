package Problem;

/**
 * 〈一句话功能简述〉<br>
 * 〈两个int整数实现读写锁〉
 *
 * @author Chenpeng
 * @create 2019/4/17
 * @since 1.0.0
 */
public class MyReadWriteLock {

    private int readCount=0;
    private int writeCount=0;

    public void lockRead() throws InterruptedException{

        while(readCount>0){
            synchronized(this){
                wait();
            }
        }
        readCount++;
    }

    public void unlockRead() throws InterruptedException{

        readCount--;
        synchronized (this){
            notifyAll();
        }
    }

    public void lockWrite() throws InterruptedException{

        while(writeCount>0){
            synchronized(this){
                wait();
            }
        }
        writeCount++;
        while(readCount>0){
            synchronized(this){
                wait();
            }
        }
    }

    public void unlockWrite() throws InterruptedException{

        writeCount--;
        synchronized (this){
            notifyAll();
        }
    }




}
