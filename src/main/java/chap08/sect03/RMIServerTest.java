package chap08.sect03;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
public class RMIServerTest {
  public static void main(String[] args) throws Exception {
    LocateRegistry.createRegistry(5000).bind("FirstRMI",new HelloImpl());
    java.rmi.Naming.bind("rmi://127.0.0.1:5000/SecondRMI", new HelloImpl());
    System.in.read();
  }
}
interface IHello extends java.rmi.Remote{
  public List<String> sayHello( String s) throws RemoteException;
}
class HelloImpl extends UnicastRemoteObject implements IHello{
  protected HelloImpl() throws RemoteException { }

  public List<String> sayHello(String s) throws RemoteException{
    System.err.println(s);
    List<String> asList = Arrays.asList("Hello " , s );
    return asList;
  }
}