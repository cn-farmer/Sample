package chap06;
public class ThreadPoolTest {
  static ThreadPoolApp<BizService,RetObject> poolApp=new ThreadPoolApp<>() {
    protected RetObject bizCall(BizService obj) {
      RetObject retObject = obj.doSomething();
      return retObject;
    }
  };
  public static void main(String[] args) throws Exception {
    var bizList = new java.util.ArrayList<BizService>();
    bizList.add(new BizService());
    bizList.add(new BizService());
    bizList.add(new BizService());
    java.util.List<RetObject> retObj = poolApp.poolExec(bizList, 2 );
} }
class BizService {
  public RetObject doSomething() throws RuntimeException {
    System.out.println("业务处理- " + Thread.currentThread().getName());
    return new RetObject( new Object());
} }
class RetObject {
  Object obj;
  public RetObject(Object obj) {
    this.obj = obj;
} }