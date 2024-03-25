package chap09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * VM参数： -Xbootclasspath/a:"d:\\slf4j-log4j12-1.7.25.jar;"
 * POM依赖：<groupId>org.slf4j</groupId><artifactId>slf4j-log4j12</artifactId><version>1.7.25</version>
 */
public class ClassLoaderTest {
  static Logger logger = LoggerFactory.getLogger(ClassLoaderTest.class);
  public static void main(String[] args) {
    logger.info("classloader ok");
  }
}