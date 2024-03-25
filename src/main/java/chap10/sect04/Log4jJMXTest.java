package chap10.sect04;
import javax.management.*;
import org.apache.log4j.*;
public class Log4jJMXTest {
  public static void main(String[] args) throws Exception {
    BasicConfigurator.configure();
    Logger logger = Logger.getLogger(Log4jJMXTest.class);
    MBeanServer mbs = java.lang.management.ManagementFactory.getPlatformMBeanServer();
    var hdm = new org.apache.log4j.jmx.HierarchyDynamicMBean();
    mbs.registerMBean( hdm, new ObjectName("log4j:hiearchy=default"));
    Thread.currentThread().sleep(-1);
  }
}