package chap08.sect01;
import java.net.Socket;
public class BIOClientTest {
  public static void main(String[] args) throws Exception{
    Socket socket = new Socket("127.0.0.1", 5000);
    socket.getOutputStream().write("hello server".getBytes());
    byte[] bytes = new byte[100];
    socket.getInputStream().read(bytes);
    System.out.println(new String(bytes));
    System.in.read();
  }
}