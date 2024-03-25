package chap10;

import org.apache.log4j.Logger;

/*
		 <dependency> <groupId>log4j</groupId> <artifactId>log4j</artifactId> 
			<version>1.2.17</version> </dependency> 
 */
public class SocketAppenderTest {
  static {
    System.setProperty("log4j.configDebug", "true");
    System.setProperty("log4j.configuration", "chap10/log4j-socket.properties");
  }
 static  Logger logger = Logger.getLogger(SocketAppenderTest.class);

  public static void main(String[] args) {
    logger.error("测试LF5 Appender!");
    logger.info("测试LF5 Appender!");
  }
}