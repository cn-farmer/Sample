package chap05.sect03;
import java.io.*;

import chap05.sect02.Person;
public class ObjectInOutTest {
  public static void main(String[] args) throws Exception, IOException {
    Person person = new Person("小明", 20, true);
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.dat"));
    oos.writeObject(person);
    oos.close();
    
//    try (var ois = new ObjectInputStream(new FileInputStream("obj.dat"))) {
//      Person readObject = (Person) ois.readObject();
//      System.out.println(readObject);
//    }
  }
}