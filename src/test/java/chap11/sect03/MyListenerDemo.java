package chap11.sect03;

import java.io.File;
import java.io.FileWriter;

import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

import chap11.CalculatorTest;
import chap11.CalculatorTest2;

public class MyListenerDemo {

  public static void main(String[] args) {
    JUnitCore jUnitCore = new JUnitCore();
    jUnitCore.addListener(new MyRunListener());
    jUnitCore.run(AnnotationChild.class, CalculatorTest.class, CalculatorTest2.class);
  }
}

class MyRunListener extends RunListener {
  FileWriter fileWriter;

  public void testRunStarted(Description description) throws Exception {
    fileWriter = new FileWriter(new File("d:/listenerdemo.txt"));
    fileWriter.write("testRunStarted: \n");
    fileWriter.flush();
  }

  public void testRunFinished(Result result) throws Exception {
    fileWriter.write("testRunFinished: " + result.getRunCount() + ",  Failures: " + result.getFailureCount()+"\n");
    fileWriter.flush();
    fileWriter.close();
  }

  public void testStarted(Description description) throws Exception {
    fileWriter.write("   testStarted :  " + description.getDisplayName() + "\n");
    fileWriter.flush();
  }
}