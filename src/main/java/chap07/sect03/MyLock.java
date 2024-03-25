package chap07.sect03;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;
public class MyLock {
  public static volatile AtomicBoolean ab = new AtomicBoolean(false);
  public void lock() {
    while (!ab.compareAndSet(false, true)) { }
  }
  public void unlock() {
    while (!ab.compareAndSet(true, false)) { }
  }
  public MyCondition newCondition() { return new MyCondition(); }
}
class MyCondition {
  java.util.List<Thread> waitSet = new CopyOnWriteArrayList<>();
  public void await() throws InterruptedException {
    while (!MyLock.ab.compareAndSet(true, false)) { }
    waitSet.add(Thread.currentThread());
    LockSupport.parkNanos(100);
    while (!MyLock.ab.compareAndSet(false, true)) { }
    waitSet.remove(Thread.currentThread());
  }
  public void signalAll() {
    java.util.Iterator<Thread> iterator = waitSet.iterator();
    while( iterator.hasNext()) {
      Thread next = iterator.next();
      LockSupport.unpark(next);
} } }