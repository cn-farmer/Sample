package chap12;

import org.junit.Assert;
import org.junit.Test;

import chap12.MyRuntimeException;

public class MyRuntimeExceptionTest {

  @Test
  public void testMyRuntimeExceptionMethod() throws NoSuchMethodException, SecurityException {

    try {
      throw new MyRuntimeException("单元测试");
    } catch (Exception e) {
      String message = e.getMessage();
      Assert.assertTrue("自定义异常命名格式不规范!",message.contains("自定义异常"));
    }
  }
}