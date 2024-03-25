package chap10.sect04;
import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;
public class HelloJMX implements HelloJMXMBean {
  private String userName = "张三";
  public void sayHello() {
    System.out.println("你好, " + this.userName);
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public String getUserName() {
    return userName;
  }
  public static void main(String[] args) throws Exception {
    MBeanServer mServer = ManagementFactory.getPlatformMBeanServer();
    ObjectName helloON = new ObjectName("myObject:type=myType,name=myHelloJMXTest");
    HelloJMX myJMX = new HelloJMX();
    mServer.registerMBean(myJMX, helloON);
    while (true) {
      System.out.println(myJMX.getUserName());
      Thread.sleep(1000);
    }
  }
}