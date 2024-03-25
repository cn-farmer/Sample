package chap10.sect04;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.TTCCLayout;

public class L7dTest {

  public static void main(String[] args) throws InterruptedException {

    Logger logger = Logger.getLogger(L7dTest.class);
    logger.addAppender(new ConsoleAppender(new TTCCLayout()));

    System.out.println( "默认本地属性:" + Locale.getDefault());
    String[] aaString = {"参数1","参数2"};

    logger.setResourceBundle(ResourceBundle.getBundle("chap10/sect04/L7D"));
    logger.l7dlog(org.apache.log4j.Level.DEBUG, "msg", aaString, null);

    Locale.setDefault(new Locale("en","US"));
    logger.setResourceBundle(ResourceBundle.getBundle("chap10/sect04/L7D"));
    logger.l7dlog(org.apache.log4j.Level.DEBUG, "msg", aaString, null);
  }
}