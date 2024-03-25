package chap06.sect02;
public class ThreadStateTest {
  public static int sleepTime = 100;
  public static void main(String[] args) throws Exception {
    class ThreadLoop extends Thread {
      public void run() { 
        synchronized (ThreadStateTest.class) { for (;;) { }}
    } } 
    ThreadLoop tLoop = new ThreadLoop();
    tLoop.start();
    class ThreadJoin extends Thread {
      public void run() { 
        try { tLoop.join(sleepTime); } catch (Exception e) { e.printStackTrace(); }
    } }
    var t1 = new ThreadJoin(); System.out.println("1 "+t1.getName()+":"+t1.getState());
    t1.start();                System.out.println("2 "+t1.getName()+":"+t1.getState());
    Thread.sleep( 10);         System.out.println("3 "+t1.getName()+":"+t1.getState());
    Thread.sleep(200);         System.out.println("4 "+t1.getName()+":"+t1.getState());
    sleepTime = 0;
    Thread t2 = new ThreadJoin();
    t2.start();
    Thread.sleep(100);         System.out.println("5 "+t2.getName()+":"+t2.getState());
    ThreadLoop t3 = new ThreadLoop();
    t3.start();
    Thread.sleep(100);         System.out.println("6 "+t3.getName()+":"+t3.getState());
    System.out.println("Hash:"+Integer.toHexString(ThreadStateTest.class.hashCode()));
    System.out.println("tLoop Hash:"+Integer.toHexString(tLoop.hashCode()));
  }
}