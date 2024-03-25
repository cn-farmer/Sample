package chap04.sect05;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

import sun.nio.cs.UTF_8;

public class PropertyUTF8Test {

  public static void main(String[] args) throws IOException {
    Properties properties = new Properties();
    properties.load(new FileReader( "./src/main/java/chap04/sect04/p.txt",new UTF_8()));
    for (Entry<Object, Object> entry : properties.entrySet()) {
     System.out.println(entry);
    }
  }
}