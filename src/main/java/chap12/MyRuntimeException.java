package chap12;

public class MyRuntimeException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public MyRuntimeException(String message) {
    super("自定义异常:" + message);
  }
}