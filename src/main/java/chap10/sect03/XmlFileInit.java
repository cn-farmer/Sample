package chap10.sect03;
import org.apache.log4j.Logger;
public class XmlFileInit {
  public static void main(String[] args) {
    System.setProperty("log4j.configDebug", "true");
    System.setProperty("ADDITIVITY_FLAG", "false");
    System.setProperty("THRESHOLD_ALL", "OFF");
    System.setProperty("log4j.configuration", "chap10/sect03/log4j.xml");
    Logger logger = Logger.getLogger(XmlFileInit.class);
    logger.debug("log4j.xml initialized.");
  }
}