package chap10.sect01;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.TTCCLayout;

public class Log4jInitTest {

 /**
  * -Dlog4j.debug=true -Dlog4j.defaultInitOverride=true
  */
  public static void main(String[] args) {
    
    TTCCLayout ttccLayout = new TTCCLayout("ISO8601");
    ttccLayout.setContextPrinting(false);
    ConsoleAppender consoleAppender = new ConsoleAppender(ttccLayout);
    consoleAppender.setTarget("System.err");
    consoleAppender.activateOptions();
    Level level = Level.toLevel("INFO");
    Logger logger = Logger.getLogger(Log4jInitTest.class);

    logger.addAppender(consoleAppender);
    logger.setLevel(level);
    logger.info("验证日志信息输出!");
  }
}