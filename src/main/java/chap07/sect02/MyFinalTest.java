package chap07.sect02;
import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;
@JCStressTest
@State
public class MyFinalTest {
  int n = 1;
  MyObject o;
  @Actor
  public void actor1() {
    o = new MyObject(n);
  }
  @Actor
  public void actor2(I_Result r) {
    MyObject m = this.o;
    if (m != null) {
      r.r1 = m.x8 + m.x7 + m.x6 + m.x5 + m.x4 + m.x3 + m.x2 + m.x1;
    } else {
      r.r1 = -1;
  } }
  public static class MyObject {
     final int y = 1;
    int x1, x2, x3, x4;
    int x5, x6, x7, x8;
    public MyObject(int v) {
      x1 = v; x2 = v; x3 = v; x4 = v; x5 = v; x6 = v; x7 = v; x8 = v;
} } }