package chap12;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import chap12.IStudent;
import chap12.MyAnnotation;
import chap12.ServerMain;
import chap12.Student;

public class ServerMainTest {
  @Test
  public void testParseStudent() throws Exception {

    PrintStream systemOut = System.out;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    List<IStudent<Number>> arrayList = new ArrayList<>();
    IStudent<Number> student = new Student<Number>(1, "小明", "123");
    arrayList.add(student);
    ServerMain.parseStudent(arrayList);

    String s = baos.toString();
    System.setOut(systemOut);
    System.out.println("testresult:" + s);
    if( !( s.contains("门面") && s.contains("观察者")  && s.contains("密码") && s.contains("注解"))) {
      Assert.fail("没有输出 门面模式、观察者模式、密码太简单、注解 等关键字!");
    }
  }
  
  @Test
  public void testServerMainAnnotation() throws Exception {
    Method method = ServerMain.class.getMethod("parseStudent", List.class);
    MyAnnotation ann = method.getAnnotation(MyAnnotation.class);
    assertEquals("parseStudent方法上没有注解！", MyAnnotation.class, ann.annotationType());
  }
}