package chap12;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import chap12.Teacher;

public class TeacherTest {
  static Teacher t;

  @BeforeClass
  public static void setupBeforeClass() {
    t = new Teacher();
  }
  @Test
  public void testClone() throws CloneNotSupportedException {
    Object c = t.clone();
    assertTrue("克隆功能错误！", t.toString().equals(c.toString())  && t.hashCode() != c.hashCode());
  }
  @Test
  public void testToString() {
    t.setId(1);
    t.setName("小明");
    t.setPassword("123456");
    assertTrue("toString格式错误！", "Teacher [id=1, name=小明, password=123456]".equals(t.toString()));
  }
}