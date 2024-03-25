package chap11;

public class EmailValidator {

  private static boolean isEmailPrivate(String email) {
    if (email != null && email.length() > 0) {
      return email.matches("^[0-9a-z]+\\w*@([0-9a-z]+\\.)+[0-9a-z]+$");
    }
    System.out.println("输入参数为空或者长度为零，不合法！");
    return false;
  }
  
  public static boolean isEmailPublic(String email) {
    return isEmailPrivate(email);
  }
}