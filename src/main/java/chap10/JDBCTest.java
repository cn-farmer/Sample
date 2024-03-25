package chap10;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTest{

  public static void main(String[] args) throws Exception {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Properties p = new Properties();

    URL resource = JDBCTest.class.getResource("/");
    p.load(new FileInputStream(resource.getPath() + "db.properties"));

    String url = "jdbc:oracle:thin:@" + p.getProperty("url");
    System.out.println("数据库连接串:" + url);
    // jdbc:oracle:thin:@10.1.95.43:1521:DMGTSTdb3
    Connection connection = DriverManager.getConnection(url, p.getProperty("username"), p.getProperty("password"));
    connection.setAutoCommit(false);
    while (true) {
      Statement createStatement = connection.createStatement();
      System.out.print("请输入SQL语句:");
      InputStream in = System.in;
      byte[] b = new byte[10000];
      in.read(b);
      String sql = new String(b);
      sql = sql.replace(";", "");
      if ("commit".equals(sql)) {
        connection.commit();
        System.out.println("commit成功");
      } else {
        createStatement.execute(sql);
        System.out.println("数据库访问成功");
      }
    }
  }
}