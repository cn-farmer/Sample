package chap02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import chap09.NoneBindTest;

public class StaticBlockTest {
  static {
    System.out.println("ok");
    System.out.println("ok");
    System.out.println("ok");
  }
  static Logger logger = LoggerFactory.getLogger(NoneBindTest.class);
	public static void main(String[] args) {
	  System.out.println("ok");
	}
}  
