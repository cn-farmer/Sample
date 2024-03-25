package chap12;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import chap12.MyConsole;
import chap12.MyLog;

public class MyLogTest {

  @Test
  public void testInfo() throws Exception {
    String log = "MyLog单元测试:" + new Date();
    MyLog.info(log);

    try (FileInputStream fis = new FileInputStream("d:/log.txt")) {
      byte[] bs = new byte[fis.available()];
      fis.read(bs);
      Assert.assertEquals("输出到文件中的内容错误！", log, new String(bs, "UTF-8"));
    }
  }
  
  @Test
  public void testMyConsole() throws UnsupportedEncodingException {
    PrintStream systemOut = System.out;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    new MyConsole().update(null, null);
    System.setOut(systemOut);

    String testResult = baos.toString();
    Assert.assertTrue("观察者模式关键字未打印！", testResult.contains("观察者模式"));
  }
}