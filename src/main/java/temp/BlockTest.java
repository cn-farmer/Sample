package temp;

import java.io.IOException;
import java.net.ServerSocket;

public class BlockTest {

  public static void main(String[] args) throws InterruptedException, IOException {
    ServerSocket serverSocket = new ServerSocket(5000);

    Thread thread = new Thread(()->{
      try {
        System.out.println("accepting");
        serverSocket.accept();
        System.out.println("accepted");
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
    
    thread.start();
    
    Thread.sleep(30000);
    serverSocket.close();
    
  }
}