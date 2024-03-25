package chap07.sect02;
import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;
@JCStressTest
@State
public class JMMOrderTest {
    int x;
   volatile int y;
  @Actor
  public void actor1(II_Result r) {
    x = 1;
    r.r2 = y;
  }
  @Actor
  public void actor2(II_Result r) {
    y = 2;
    r.r1 = x;
  }
}