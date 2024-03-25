package chap08.sect03;
import java.io.*;
import java.net.*;
public class RPCServerTest {
  public static void main(String[] args) throws Exception {
    ServerSocket serverSocket = new ServerSocket(5000);
    while (true) {
      Socket socket = serverSocket.accept();
      ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

      String className = ois.readUTF();
      String methodName = ois.readUTF();
      Class[] parameterTypes = (Class[]) ois.readObject();
      Object[] inArgs = (Object[]) ois.readObject();

      Class<?> clazz = Class.forName(className);
      java.lang.reflect.Method method = clazz.getMethod(methodName, parameterTypes);
      Object invoke = method.invoke(clazz.newInstance(), inArgs);

      ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
      oos.writeObject(invoke);
    }
  }
}
interface IQuery extends Serializable{
  public java.util.List<String> sayHello( String msg);
}
class QueryImpl implements IQuery {
  public java.util.List<String> sayHello(String msg) {
    System.err.println(msg);
    return java.util.Arrays.asList("hello", " client");
  }
}