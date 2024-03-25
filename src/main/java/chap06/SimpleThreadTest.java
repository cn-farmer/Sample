package chap06;
public class SimpleThreadTest {
  public static void main(String[] args) throws InterruptedException {
    new MySimpleThread().start();
    new Thread(new MySimpleRunnable()).start();
    new Thread(()->System.out.println(Thread.currentThread().getName()+":use Lambda.")).start();
    System.out.println("main Thread end.");
  }
}
class MySimpleThread extends Thread {
  public void run() {
    System.out.println(Thread.currentThread().getName() + ": extend Thread.");
  }
}
class MySimpleRunnable implements Runnable {
  public void run() {
    System.out.println(Thread.currentThread().getName() + ": implements runnable.");
  }
}