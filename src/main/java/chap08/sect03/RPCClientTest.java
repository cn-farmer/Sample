package chap08.sect03;
import java.io.*;
import java.lang.reflect.*;
import java.net.Socket;
public class RPCClientTest {
  public static void main(String[] args) throws Exception {
    IQuery iQuery = (IQuery) RPC.init(IQuery.class,"chap08.sect03.QueryImpl");
    java.util.List<String> queryByName = iQuery.sayHello( "hello server" );
    System.err.println(queryByName);
  }
}
class RPC{
  public static Object init(Class o, String className) {
    return Proxy.newProxyInstance(o.getClassLoader(), new Class[]{o}, new InvocationHandler() {
      public Object invoke(Object p, Method method, Object[] args) throws Throwable {
        Socket socket = new Socket("127.0.0.1",5000);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        oos.writeUTF(className);
        oos.writeUTF(method.getName());
        oos.writeObject( method.getParameterTypes());
        oos.writeObject(args);
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        return ois.readObject();
      }
    });
  }
}