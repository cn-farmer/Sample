package chap09;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JCLOverSlf4jTest {
  static {
    System.setProperty("log4j.configuration", "chap09/log4j-jcloverslf4j.properties");
  }
  public static void main(String[] args) {
    Log log = LogFactory.getLog(JCLOverSlf4jTest.class);
    log.info("jcl - slf4j - log4j ok");
  }
}