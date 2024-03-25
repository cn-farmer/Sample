package chap12;
	
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import chap12.ClientMain;
import chap12.IStudent;
import chap12.SendInfoRunnable;

public class ClientMainTest {

  @Test
  public void testClient() throws Exception {
    SendInfoRunnable.studentList = new ArrayList<>();
    SendInfoRunnable.completedFlag = false;
    Socket socket = mock(Socket.class);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    when(socket.getOutputStream()).thenReturn(baos);
    ClientMain.sendInfo(socket);
    
    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
    @SuppressWarnings("unchecked")
    ArrayList<IStudent<Number>> studentList = (ArrayList<IStudent<Number>>) ois.readObject();

    Assert.assertEquals("客户端模拟输出内容不正确！", 6, studentList.size());
	}
}