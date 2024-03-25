package chap08.sect03;
import java.lang.reflect.Method;
import java.util.List;
public class RMIClientTest {
  public static void main(String[] args) throws Exception {
    java.rmi.Remote lookup1 = java.rmi.Naming.lookup("rmi://127.0.0.1:5000/FirstRMI");
    System.out.println(((IHello)lookup1).sayHello("接口直连模式"));

    java.rmi.Remote lookup2 = java.rmi.Naming.lookup("rmi://127.0.0.1:5000/SecondRMI");
    Method method = lookup2.getClass().getMethod("sayHello", String.class);
    List<String> list = (List<String>) method.invoke(lookup2, "方法反射模式");
    System.out.println(list);
  }
}