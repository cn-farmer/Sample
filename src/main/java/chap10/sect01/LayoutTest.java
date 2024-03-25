package chap10.sect01;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.RootLogger;
public class LayoutTest {
  public static void main(String[] args) {
    Layout layout = new PatternLayout("ABC%d{HH:mm:ss,SSS}%n[%5.9t]%8p %-6c%m");
    RootLogger logger = new RootLogger(Level.DEBUG);
    LoggingEvent event = new LoggingEvent(null, logger, Level.DEBUG, "layout测试", null);
    String format = layout.format(event);
    System.out.println(format);
  }
}