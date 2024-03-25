package chap11.sect03;

import org.junit.runner.RunWith;

@RunWith(MyCustomRunner.class)
public class MyRunnerDemo {
  public void cycleCase(int cycle) {
    for(int i = 1; i <= cycle; i++ )
    System.out.println("循环次数 ：" + i );
  }
}