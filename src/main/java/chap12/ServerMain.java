package chap12;

import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import chap12.MyAnnotation.ProcessType;

public class ServerMain {
  public static void main(String[] args) throws Exception {
    FutureTask<List<IStudent<Number>>> futureTask = new FutureTask<>(new ReceiveInfoCallable());
    new Thread(futureTask).start();

    parseStudent(futureTask.get(10, TimeUnit.SECONDS));
  }

  @MyAnnotation(process = ProcessType.JUMP)
  public static void parseStudent(List<IStudent<Number>> studentList) {
    IStudent<Number> student = studentList.get(0);
    IPasswordFacade studentFacade = student;
    studentFacade.setPassword("12345678");
    IPasswordFacade teacherFacade = student.getTeacher();
    teacherFacade.setPassword("87654321");
    System.out.println("门面模式触发了");

    MyConsole myConsole = new MyConsole();
    MyLog myLog = new MyLog();
    student.addObserver(myConsole);
    student.addObserver(myLog);
    student.getPassword();
    @SuppressWarnings("unchecked")
    IStudent<Number> factory = (IStudent<Number>) MyProxy.factory(student);
    factory.setPassword("123");

    student.setId(100);
    System.out.println("注解功能验证:" + student.getId());
  }
}