package chap12;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class MyLog implements Observer {
  static BufferedOutputStream bos = null;
  static {
    try {
      bos = new BufferedOutputStream(new FileOutputStream("d:/log.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static void info(String message) {
    try {
      bos.write(message.getBytes());
      bos.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  @Override
  public void update(Observable o, Object arg) {
    info("观察者模式触发了");
  }
}

class MyConsole implements Observer {
  public static void info(String message) {
    System.out.println("主控台:" + message);
  }
  @Override
  public void update(Observable o, Object arg) {
    info("观察者模式触发了");
  }
}