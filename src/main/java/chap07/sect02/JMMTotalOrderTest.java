package chap07.sect02;
import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;
@JCStressTest
@State
public class JMMTotalOrderTest {
    volatile int x;
    volatile int y;
  @Actor
  public void actor1() {
    x = 1;
    y = 2;
  }
  @Actor
  public void actor2(II_Result r) {
    r.r2 = y;
    r.r1 = x;
} }