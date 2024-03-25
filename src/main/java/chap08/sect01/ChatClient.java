package chap08.sect01;
import java.io.*;
import java.net.Socket;
public class ChatClient {
  public static void main(String[] args) throws Exception {
    Socket socket = new Socket("localhost", 5000);
    new Thread(() -> {
      try {
        while (true) {
          var reader = new BufferedReader(new InputStreamReader( System.in ));
          socket.getOutputStream().write( reader.readLine().getBytes());
        }
      } catch (Exception e) { e.printStackTrace(); }
    }).start();

    InputStream inputStream = socket.getInputStream();
    byte[] bs = new byte[1024];
    while (inputStream.read( bs ) > 0 ) {
      System.err.println(new String(bs));
    }
  }
}