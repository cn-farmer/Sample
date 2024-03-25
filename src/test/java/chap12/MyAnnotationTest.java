package chap12;

import static org.junit.Assert.assertEquals;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.Test;

import chap12.IStudent;
import chap12.MyAnnotation;
import chap12.Student;
import chap12.MyAnnotation.ProcessType;

public class MyAnnotationTest {
  @Test
  public void testDefaultProcess() throws Exception {
    Method method = MyAnnotation.class.getMethod("process", (Class<?>[]) null);
    Object defaultValue = method.getDefaultValue();
    assertEquals("注解中默认值设置错误！", defaultValue, MyAnnotation.ProcessType.EXECUTE);
  }

  @Test
  @MyAnnotation(process = ProcessType.JUMP)
  public void testAnnotation() {
    IStudent<Integer> student = new Student<Integer>(1, "小明", "123456");
    student.setId(1234);
    assertEquals("JUMP注解验证失败！", Integer.valueOf(1), student.getId());
  }
}