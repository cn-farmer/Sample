package chap10.sect05;
import org.apache.log4j.*;
public class HookTest {
  public static void main(String[] args) throws InterruptedException {
    BasicConfigurator.configure(new HookAppender(new PatternLayout("[%t] %p %m%n")));
    Logger logger = Logger.getLogger(HookTest.class);
    logger.debug("hook Test");
  }
}

class HookAppender extends ConsoleAppender {
  public HookAppender(Layout layout) {
    super(layout);
    Runtime.getRuntime().addShutdownHook(new HookThread());
    this.immediateFlush=false;
  }
  class HookThread extends Thread {
    public void run() {
      qw.flush();
      System.err.println("钩子程序被调用了！");
    }
  }
}