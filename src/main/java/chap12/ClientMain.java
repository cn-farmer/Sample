package chap12;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientMain {
  static IStudent<Number> student;
  static {
    try {
      @SuppressWarnings("unchecked")
      Class<IStudent<Number>> forName = (Class<IStudent<Number>>) Class.forName("chap12.Student");
      Constructor<IStudent<Number>> constructor = forName.getConstructor(Number.class, String.class, String.class);
      student = constructor.newInstance(1, "小明", "123456");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws Exception {
    try(Socket socket = new Socket()){
    sendInfo(socket);
    System.out.println("clientMain end!");
    }
  }
  public static void sendInfo(Socket socket) throws Exception {
    final CountDownLatch countDownLatch = new CountDownLatch(1);
    new Thread(new Runnable() {
      public void run() {
        while (!SendInfoRunnable.completedFlag) {
        }
        countDownLatch.countDown();
      }
    }).start();
    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
    newFixedThreadPool.execute(new SendInfoRunnable(0, student));
    newFixedThreadPool.execute(new SendInfoRunnable(1, student));
    newFixedThreadPool.execute(new SendInfoRunnable(2, student));
    countDownLatch.await();

    Collections.sort(SendInfoRunnable.studentList, new MyDescStrategy());

    socket.connect(new InetSocketAddress("localhost", 5000));
    OutputStream sos = socket.getOutputStream();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);

    oos.writeObject(SendInfoRunnable.studentList);
    sos.write(baos.toByteArray());
  }
}