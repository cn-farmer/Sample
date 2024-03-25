package chap12;

import static org.junit.Assert.assertArrayEquals;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

import org.junit.Test;

import chap12.IStudent;
import chap12.ReceiveInfoCallable;
import chap12.Student;

public class ReceiveInfoCallableTest {

  @Test
  public void testServerSocket() throws Exception {
    FutureTask<List<IStudent<Number>>> futureTask = new FutureTask<>(new ReceiveInfoCallable());
    new Thread(futureTask).start();

    List<IStudent<Number>> list = new ArrayList<>();
    try (Socket socket = new Socket("localhost", 5000)) {
      OutputStream socketOutputStream = socket.getOutputStream();
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(baos);
      list.add(new Student<Number>(1, "xm", null));
      oos.writeObject(list);

      socketOutputStream.write(baos.toByteArray());
    } catch (Exception e) {
      e.printStackTrace();

      List<IStudent<Number>> studentList = futureTask.get();
      assertArrayEquals(studentList.toArray(), list.toArray());

//    assertTrue("网络接收错误！", student.toString().contains("Student [id=1, name=小明, password=null"));
    }
  }
}