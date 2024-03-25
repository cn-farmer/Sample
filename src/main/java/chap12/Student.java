package chap12;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Observable;

import chap12.MyAnnotation.ProcessType;

public class Student<T extends Number> extends Observable implements Cloneable, Serializable, IStudent<T> {
  private static final long serialVersionUID = 1L;
  T id;
  String name;
  transient String password;
  Teacher teacher = new Teacher();  

  public Student(T id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
  }
  public T getId() {
    return id;
  }
  public void setId(T id) {
    try {
      StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
      StackTraceElement element = stackTrace[2];

      Class<?> className = Class.forName( element.getClassName());
      MyAnnotation annotation = className.getAnnotation(MyAnnotation.class);
      if (annotation == null) {
        for (Method method : className.getDeclaredMethods()) {
          if (method.getName().equals( element.getMethodName())) {
            annotation = method.getAnnotation( MyAnnotation.class );
          }
        }
      }

      if (annotation == null || (annotation.process() == ProcessType.EXECUTE)) {
        this.id = id;
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    setChanged();
    notifyObservers();
    return password;
  }
  public void setPassword(String password) {
    if ("123".equals(password)) {
      throw new MyRuntimeException("密码太简单了");
    }
    this.password = password;
  }
  public Teacher getTeacher() {
    return teacher;
  }
  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    @SuppressWarnings("unchecked")
    IStudent<Number> clone = (IStudent<Number>) super.clone();
    clone.setTeacher( (Teacher)this.getTeacher().clone());
    return clone;
  }
  public String toString() {
    return "\nStudent [id="+id+", name="+name+", password="+password+", teacher="+teacher+"]";
  }
}