package chap09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* 
 *  <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-log4j12</artifactId>
      <version>1.7.25</version>
    </dependency>
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>log4j-over-slf4j</artifactId>
      <version>1.7.25</version>
    </dependency>
 */
public class LoopBindTest {
  static Logger logger = LoggerFactory.getLogger(LoopBindTest.class);
  public static void main(String[] args) {
    logger.info("loop bind test");
  }
}