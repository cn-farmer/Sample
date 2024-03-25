package chap12;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy implements InvocationHandler {
  Object object;

  private MyProxy(Object object) {
    this.object = object;
  }

  public static Object factory(Object o) {
    return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), new MyProxy(o));
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    try {
      System.out.println("before invoke");
      Object invoke = method.invoke(object, args);
      System.out.println("after invoke");
      return invoke;
    } catch (Exception e) {
      String message = (e.getCause() == null) ? e.getMessage() : e.getCause().getMessage();
      System.out.println(message);
    }
    return null;
  }
}