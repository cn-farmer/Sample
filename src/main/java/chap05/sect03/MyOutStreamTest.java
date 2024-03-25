package chap05.sect03;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import chap05.sect02.Person;

public class MyOutStreamTest {
  public static void main(String[] args) throws Exception {
    Person person = new Person("小明", 30, true);
    MyOutStream mos = new MyOutStream(new BufferedOutputStream(new FileOutputStream("mos.txt")));
    mos.writeUTF(person.getName());
    mos.writeint(person.getAge());
    mos.writeboolean(person.isMarried());
    mos.flush();
//    mos.close();
  }
}