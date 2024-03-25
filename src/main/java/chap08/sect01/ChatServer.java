package chap08.sect01;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class ChatServer {
  public static void main(String[] args) throws Exception {
    ServerSocket serverSocket = new ServerSocket(5000);
    Socket socket = serverSocket.accept();
    new Thread(() -> {
      try {
        while (true) {
          String nextLine = new Scanner(System.in).nextLine();
          socket.getOutputStream().write(nextLine.getBytes());
        }
      } catch (Exception e) { e.printStackTrace(); }
    }).start();

    socket.getInputStream().transferTo(System.err);
  }
}