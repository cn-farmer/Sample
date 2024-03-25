package temp;

public class SyncTest {
  public static Integer lock1 = 1;
  public static Integer lock2 = 1;
  public static Integer lock3 = 1;
  public static Integer thread = 10;
  public static int count = 0;
  public static Integer tt = 0;

  public static void main(String[] args) throws InterruptedException {
    new Thread(new c10()).start();
    new Thread(new c20()).start();
    new Thread(new c30()).start();
  }
}

class c10 extends Thread {
  public void run() {
    for (int i = 0; i < 1000; i++) {
      synchronized (SyncTest.lock1) {
        if (SyncTest.thread != 10) {
          SyncTest.count++;
          SyncTest.thread = 10;
        }
        System.out.println("10  lock1");
      }
      synchronized (SyncTest.lock2) {
        System.out.println("10   lock2");
      }
    }
    System.out.println("count:" + SyncTest.count);
    System.out.println("tt:" + SyncTest.tt);
  }
}

class c20 extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 1000; i++) {
      synchronized (SyncTest.lock2) {
        if (SyncTest.thread != 20) {
          SyncTest.count++;
          SyncTest.thread = 20;
        }
        System.out.println("20 lock3");
      }
      synchronized (SyncTest.lock3) {
        System.out.println("20   lock2");
      }
    }
    System.out.println("count:" + SyncTest.count);
    System.out.println("tt:" + SyncTest.tt);
  }
}

class c30 extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 1000; i++) {
      synchronized (SyncTest.lock3) {
        if (SyncTest.thread != 30) {
          SyncTest.count++;
          SyncTest.thread = 30;
        }
        System.out.println("30 lock3");
      }
      synchronized (SyncTest.lock1) {
        System.out.println("30 lock1");
      }
    }
    System.out.println("count:" + SyncTest.count);
    System.out.println("tt:" + SyncTest.tt);
  }
}