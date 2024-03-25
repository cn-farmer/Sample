package chap12;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Assert;
import org.junit.Test;

import chap12.IStudent;
import chap12.SendInfoRunnable;
import chap12.Student;

public class SendInfoRunnableTest {
  @Test
  public void testThread() throws Exception {
    SendInfoRunnable.studentList = new ArrayList<>();
    SendInfoRunnable.completedFlag = false;
    IStudent<Number> student = new Student<>(1, "小明", "123456"); 
    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
    newFixedThreadPool.execute(new SendInfoRunnable(0, student));
    newFixedThreadPool.execute(new SendInfoRunnable(1, student));
    newFixedThreadPool.execute(new SendInfoRunnable(2, student));
    Thread.sleep(100);

    String ids = "";
    for (int i = 0; i < 6; i++) {
      ids = ids + SendInfoRunnable.studentList.get(i).getId() + ",";
    }
    Assert.assertEquals("没有按顺序生成主键为1-6的数据！","1,2,3,4,5,6,", ids );

  }
}