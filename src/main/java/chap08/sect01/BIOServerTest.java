package chap08.sect01;
import java.net.ServerSocket;
import java.net.Socket;
public class BIOServerTest {
  public static void main(String[] args) throws Exception {
    ServerSocket serverSocket = new ServerSocket(5000);
    Socket socket = serverSocket.accept();
    byte[] bytes = new byte[100];
    socket.getInputStream().read(bytes);
    System.out.println(new String(bytes));
    socket.getOutputStream().write("hello client".getBytes());
  }
}