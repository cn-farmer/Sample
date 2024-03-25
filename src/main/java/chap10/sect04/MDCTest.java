package chap10.sect04; 
import org.apache.log4j.*;
public class MDCTest {
  public static void main(String[] args) {
    BasicConfigurator.configure(new ConsoleAppender(new PatternLayout("[%-8t] %p [%X{appId}] %m%n")));
    Logger logger = Logger.getLogger(MDCTest.class);
    MDC.put("appId", "message from MDC!");
    logger.debug("主线程输出");
    new Thread(()->logger.debug("子线程输出")).start();
  }
}