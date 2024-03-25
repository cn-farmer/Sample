package chap07.sect03;
public class AQSTest extends java.util.concurrent.locks.AbstractQueuedSynchronizer{
  protected final boolean tryAcquire(int acquires) {
    final Thread current = Thread.currentThread();
    int c = getState();
    if (c == 0) {
        if (!hasQueuedPredecessors() && compareAndSetState(0, acquires)) {
            setExclusiveOwnerThread(current);
            return true;
    }   }
    else if (current == getExclusiveOwnerThread()) {
        int nextc = c + acquires;
        if (nextc < 0)
            throw new Error("Maximum lock count exceeded");
        setState(nextc);
        return true;
    }
    return false;
}
  protected final boolean tryRelease(int releases) {
    int c = getState() - releases;
    if (Thread.currentThread() != getExclusiveOwnerThread())
      throw new IllegalMonitorStateException();
    boolean free = false;
    if (c == 0) {
      free = true;
      setExclusiveOwnerThread(null);
    }
    setState(c);
    return free;
  }
  static Integer count = Integer.valueOf(0);
  public static void main(String[] args) throws InterruptedException {
    AQSTest aqs = new AQSTest();
    for (int i = 0; i < 3; i++) {
      new Thread(() -> {
        aqs.acquire(1);
        try {
          count++;
        } finally { aqs.release(1); }
      }).start();
    }
    Thread.sleep(2000);
    System.out.println("累加计数=" + count);
} }