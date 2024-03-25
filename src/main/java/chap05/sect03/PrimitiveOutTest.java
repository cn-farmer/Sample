package chap05.sect03;
import java.io.*;

import chap05.sect02.Person;
public class PrimitiveOutTest {
  public static void main(String[] args) throws Exception {
    Person person = new Person("小明", 15, true);
    var dos = new DataOutputStream(new FileOutputStream("primitive.txt"));

    dos.writeUTF(person.getName());
    dos.writeInt(person.getAge());
    dos.writeBoolean(person.isMarried());
    dos.close();
  }
}