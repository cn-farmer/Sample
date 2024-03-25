package chap09;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormatTest {

  static {
    System.setProperty("log4j.configuration", "chap09/log4j-format.properties");
  }
  static Logger logger = LoggerFactory.getLogger(FormatTest.class);

  public static void main(String[] args) throws IOException {
    Map<Object, Object> map = new HashMap<>();
    map.put(1, "aa");
    map.put(2, "bb");
    logger.info("有替换-\\{} -{} -{} -{}", map, true,null);
    logger.info("有替换-\\\\{} -{} -{} -{}", map, true,null);
    logger.info("有替换-\\{} -{} -{} -{}", map, true,null, new Exception("出异常了"));
    logger.info("有替换-{} -{} -{} -{}", map, true, new Exception("出异常了"),null);
    logger.info("无替换,正常输出!", map, true );

//    Object[] objects = new Object[2];
//    objects[0] = objects;
//    logger.info("模拟递归特殊场景问题{}",objects);
  }
}