package chap09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class MarkerTest {
  static {
    System.setProperty("log4j2.configurationFile", "chap09/log4j2-marker.xml");
  }
  static Logger logger = LoggerFactory.getLogger(MarkerTest.class);
  static Marker marker1 = MarkerFactory.getMarker("m1");
  static Marker marker2 = MarkerFactory.getMarker("m2");

  public static void main(String[] args) {
    logger.debug(marker1, "marker1 output");
    logger.debug(marker2, "marker2 output");
  }
}