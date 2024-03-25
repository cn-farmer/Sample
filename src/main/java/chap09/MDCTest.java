package chap09;

import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class MDCTest {
  static {
    System.setProperty("isThreadContextMapInheritable", "true");
    System.setProperty("log4j.configuration", "chap09/log4j-mdc.properties");
    System.setProperty("log4j.configurationFile", "chap09/log4j2-mdc.xml");
    System.setProperty("logback.configurationFile", "chap09/logback-mdc.xml");
  }

  public static void main(String[] args) {
    Logger logger1 = LoggerFactory.getLogger(MDCTest.class);
    MDC.put("myMDC", "测试MDC");
    logger1.info("主线程");
    new Thread(new Runnable() {

      public void run() {
        logger1.info("子线程");
        Executors.newFixedThreadPool(1).execute(new MyMDCThread());
      }
    }).start();
  }
}

class MyMDCThread extends Thread {
  public void run() {
    Logger logger2 = LoggerFactory.getLogger(MyMDCThread.class);
    logger2.info("子子线程");
  }
}