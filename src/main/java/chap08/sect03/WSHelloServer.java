package chap08.sect03;
import java.util.*;
@javax.jws.WebService(endpointInterface = "chap08.sect03.WSHelloServer")
public class WSHelloServer {
  public List<String> sayHello(String s) {
    List<String> list = new ArrayList<>();  
    System.out.println(s);
    list.add("hello client");
    return list;
  }
  public static void main(String[] args) {
    javax.xml.ws.Endpoint.publish("http://127.0.0.1:5000/hello", new WSHelloServer());
  }
}