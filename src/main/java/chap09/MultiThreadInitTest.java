package chap09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 *  <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-log4j12</artifactId>
      <version>1.7.25</version>
    </dependency>
 */
public class MultiThreadInitTest {
  static {
    System.setProperty("log4j.configuration", "chap09/log4j-multithread.properties");
  }
  public static void main(String[] args) {
    new MyThread().start();
    new MyThread().start();
  }
}
class MyThread extends Thread{
  @Override
  public void run() {
    Logger logger = LoggerFactory.getLogger(MultiThreadInitTest.class);
    logger.info("线程名称是：" + Thread.currentThread().getName());
  }
}