package chap12;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;

public class MyClassLoader extends ClassLoader {
  @Override
  public Class<?> findClass(String name) {
    String classFile = this.getResource("").getPath().replace("test-classes", "classes");
    classFile = classFile + name.replace(".", "/") + ".class";

    try (FileInputStream fileInputStream = new FileInputStream(classFile)) {

      byte[] bs = new byte[fileInputStream.available()];
      fileInputStream.read(bs);

      return defineClass(name, bs, 0, bs.length);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public static void main(String[] args) throws Exception {
    MyClassLoader myClassLoader = new MyClassLoader();
    myClassLoader.findClass("chap12.IPasswordFacade");
    myClassLoader.findClass("chap12.Teacher");
    myClassLoader.findClass("chap12.IStudent");
    Class<?> student = myClassLoader.findClass("chap12.Student");
    Constructor<?> constructor = student.getConstructor(Number.class, String.class, String.class);
    Object newInstance = constructor.newInstance(321, "李四", "123321");
    System.out.println(newInstance);
  }
}