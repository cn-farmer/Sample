package chap04.sect05;
import java.util.Map.Entry;
public class SystemTest {
  public static void main(String[] args) {
    java.util.Properties properties = System.getProperties();
    for (Entry<Object, Object> entry : properties.entrySet()) {
      System.out.println(entry);
    }
    System.out.println("----------------------------------");
    java.util.Map<String, String> env = System.getenv();
    for (Entry<String, String> entry : env.entrySet()) {
      System.out.println(entry);
    }
  }
}