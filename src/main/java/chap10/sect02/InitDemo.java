package chap10.sect02;
import org.apache.log4j.Logger;
public class InitDemo {
  public static void main(String[] args) {
    System.setProperty("log4j.configuration", "chap10/sect02/InitDemo.properties");
    Logger logger = Logger.getLogger(InitDemo.class);
    logger.debug("log4j initialized.");
  }
}