package chap07.sect03;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public class ReentrantRWTest {
  public static void main(String[] args) {
    ReentrantReadWriteLock reRW = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock readLock = reRW.readLock();
    ReentrantReadWriteLock.WriteLock writeLock = reRW.writeLock();

    new Thread(()-> {
      readLock.lock();
      readLock.lock();
      System.out.println(readLock);
    }).start();

    new Thread(()-> { writeLock.lock(); }).start();
    
    System.out.println(reRW);
  }
}