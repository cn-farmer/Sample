package chap10.sect03;
import org.apache.log4j.Logger;
public class PropFileInit {
  public static void main(String[] args) {
    System.setProperty("log4j.configDebug", "true");
    System.setProperty("ADDITIVITY_FLAG", "true");
    System.setProperty("log4j.configuration", "chap10/sect03/PropDemo.properties");
    Logger logger = Logger.getLogger(PropFileInit.class);
    logger.debug("log4j initialized.");
  }
}