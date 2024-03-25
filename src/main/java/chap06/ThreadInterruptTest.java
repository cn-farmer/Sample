package chap06;

public class ThreadInterruptTest {
  public static void main(String[] args) throws InterruptedException {
    new MyInterruptLoop().start();
    Thread.sleep(100);
    MyInterruptLoop myInterruptLoop = new MyInterruptLoop();
    myInterruptLoop.start();
    myInterruptLoop.interrupt();

    Thread myInterruptInner = new Thread(()-> {
        try {
          Thread.sleep(110);
        } catch (InterruptedException e) {
          System.out.println("inteibbbbrrupt " + Thread.currentThread().getName());
        }
    });
    myInterruptInner.start();
    myInterruptInner.interrupt();
  }
}

class MyInterruptLoop extends Thread {
  public void run() {
    synchronized (ThreadInterruptTest.class) {
      for (;;) {
        if (Thread.currentThread().isInterrupted()) {
          System.out.println("interruaaaapt " + Thread.currentThread().getName());
          return;
        }
      }
    }
  }
}