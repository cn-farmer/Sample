package chap12;

import java.util.ArrayList;
import java.util.List;

public class SendInfoRunnable implements Runnable {
  public static List<IStudent<Number>> studentList = new ArrayList<IStudent<Number>>();
  public static volatile boolean completedFlag = false;
  int mode;
  IStudent<Number> student;

  public SendInfoRunnable(int mode, IStudent<Number> student) {
    this.mode = mode;
    this.student = student;
  }

  public void run() {
    try {
      for (int i = 0; i < 2; i++) {
        synchronized (studentList) {
          while (studentList.size() % 3 != mode) {
            studentList.wait();
          }
          IStudent<Number> newStudent = cloneStudent(this.student);
          studentList.add(newStudent);
          studentList.notifyAll();
        }
      }
      if (mode == 2) {
        completedFlag = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static IStudent<Number> cloneStudent(IStudent<Number> s) {
    try {
      @SuppressWarnings("unchecked")
      IStudent<Number> student = (IStudent<Number>) s.clone();
      int id = SendInfoRunnable.studentList.size() + 1;
      student.setId(id);
      student.setName("xm_" + id);
      student.setPassword("mm_" + id);
      return student;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}