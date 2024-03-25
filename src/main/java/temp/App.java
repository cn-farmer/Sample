package temp;

import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;

public class App {

  public static void main(String[] args) throws Exception {

    new Thread(new Runnable() {
      public void run() {
        try {
          MBeanServer mServer = ManagementFactory.getPlatformMBeanServer();
          ObjectName helloON = new ObjectName("aaaa:type=bbbb,name=helloJMXkjfsdjf");
          HelloJMXMBean2 myJMX = new HelloJMXMBean2();
          mServer.registerMBean(myJMX, helloON);
        } catch (Exception e) { e.printStackTrace(); }
      }
    }).start();
    
    while(true) {
//      System.out.println(myJMX.getUserName());
      Thread.sleep(1000);
    }
  }
}

interface HelloJMXMBean2MBean {
  void sayHello();
  void setUserName(String userName);
  String getUserName();
  String getNowTime();
}

class HelloJMXMBean2 implements HelloJMXMBean2MBean {
  private String userName;

  public void sayHello() {
    if (this.userName == null) {
      System.out.println("请从jconsole中输入用户名!");
    } else {
      System.out.println("Hello, " + this.userName);
    }
  }

  public void setUserName(String userName) {
    this.userName = userName;
    System.out.println(userName);
  }
  public String getUserName() {
    return userName;
  }
  public String getNowTime() {
    return Long.toString(System.currentTimeMillis());
  }
}