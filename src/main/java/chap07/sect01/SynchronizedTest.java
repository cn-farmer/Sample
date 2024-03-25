package chap07.sect01;
public class SynchronizedTest {
  Object object = new Object();
  public static synchronized void staticMethod() {
    System.out.println("in static method");
    synchronized (SynchronizedTest.class) {
      System.out.println("in SynchronizedTest.class");
  } }
  public synchronized void nonStaticMethod() {
    System.out.println("in nonStatic method");
    synchronized (SynchronizedTest.class) {
      System.out.println("in SynchronizedTest.class");
      synchronized (this) {
        System.out.println("in this");
        synchronized (object) {
          System.out.println("in object");
          staticMethod();
  } } } }
  public static void main(String[] args) throws Exception {
    SynchronizedTest sync = new SynchronizedTest();
    sync.nonStaticMethod();
} }