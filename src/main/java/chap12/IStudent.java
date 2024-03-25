package chap12;

import java.util.Observer;

public interface IStudent<T extends Number> extends IPasswordFacade {

  T getId();
  void setId(T id);

  String getName();
  void setName(String name);

  String getPassword();
  void setPassword(String password);

  Teacher getTeacher();
  void setTeacher(Teacher teacher);

  Object clone() throws CloneNotSupportedException;
 
  String toString();

  public void addObserver(Observer o);
}