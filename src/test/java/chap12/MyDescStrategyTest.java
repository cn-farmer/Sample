package chap12;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import chap12.IStudent;
import chap12.MyDescStrategy;
import chap12.Student;

public class MyDescStrategyTest {
  @Test
  public void testCompare() {
    IStudent<Number> student1 = new Student<Number>(1, "Tom", "1234");
    IStudent<Number> student2 = new Student<Number>(2, "Jerry", "1234");
    MyDescStrategy myDescStrategy = new MyDescStrategy();
    int compare = myDescStrategy.compare(student1, student2);
    assertTrue("排序策略的判断逻辑错误！", compare > 0);
  }
}