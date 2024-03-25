package chap12;
import java.io.Serializable;

public class Teacher implements Cloneable, Serializable, IPasswordFacade {
  private static final long serialVersionUID = 1L;

  int id;
  String name;
  String password;

  public Teacher() {
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
  @Override
  public String toString() {
    return "Teacher [id=" + id + ", name=" + name + ", password=" + password + "]";
  }
}

interface IPasswordFacade {
  public void setPassword(String password);
}