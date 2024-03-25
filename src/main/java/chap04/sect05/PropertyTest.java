package chap04.sect05;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertyTest {

  public static void main(String[] args) throws IOException {
    Properties prop = new Properties();
    prop.load(new FileInputStream( "./src/main/java/chap04/sect05/p.properties"));
    for (Entry<Object, Object> entry : prop.entrySet()) {
     System.out.println(entry);
    }
  }
}