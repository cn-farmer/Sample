package chap10.sect01;

import org.apache.log4j.Logger;

/*
		 <dependency> <groupId>log4j</groupId> <artifactId>log4j</artifactId> 
			<version>1.2.17</version> </dependency> 
 */
public class NTAppenderTest {
  static {
    System.setProperty("log4j.configDebug", "true");
    System.setProperty("log4j.configuration", "chap10/sect01/ntappender.properties");
  }
 static  Logger logger = Logger.getLogger(NTAppenderTest.class);

  public static void main(String[] args) {
    logger.error("现在可以将日志输出到事件查看器了!");
  }
}