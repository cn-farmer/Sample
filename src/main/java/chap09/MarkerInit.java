package chap09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 *POM: <groupId>org.slf4j</groupId><artifactId>slf4j-log4j12</artifactId><version>1.7.25</version> 
 */
public class MarkerInit {
  static {
    System.setProperty("log4j.configuration", "chap09/log4j-markerinit.properties");
  }
  public static void main(String[] args) {
    Marker marker = MarkerFactory.getMarker("m2");
    Logger logger = LoggerFactory.getLogger(MarkerInit.class);
    logger.info(marker,"--- marker init");
//    logger.info("--- init end");
  }
}