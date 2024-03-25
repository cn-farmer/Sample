package chap05.sect02;
public class Person implements java.io.Serializable{
  private static final long serialVersionUID = 1L;
  String name;
  int age;
  transient boolean married;

  public Person(String name, int age, boolean married) {
    this.name = name;
    this.age = age;
    this.married = married;
  }
  public String getName() {    return name;    }
  public int getAge() {    return age;    }
  public boolean isMarried() {    return married;   }

  public String toString() {
    return  name + "|" + age + "|" + married;
  }
}