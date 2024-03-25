package temp;

import java.util.Date;

public class T3 {
  public static void main(String[] args) {
    System.out.println("start" + new Date());
    for( long i = 0; i < Integer.MAX_VALUE; i++ ) {
     double d = i*1.01d ;
    }
//    LockSupport.parkUntil(T3.class,(new Date()).getTime()+200000);
    System.out.println("end" + new Date());
  }
}