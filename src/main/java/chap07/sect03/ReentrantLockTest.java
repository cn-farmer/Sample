package chap07.sect03;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
  public static ReentrantLock lock = new ReentrantLock();
  public static void main(String[] args) {
    lock.lock();
    try {

    } finally {
      lock.unlock();
    }
  }
}