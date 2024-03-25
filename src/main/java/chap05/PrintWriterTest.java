package chap05;
import java.io.*;
public class PrintWriterTest {
  public static void main(String[] args) throws Exception {
    PrintWriter pWriter = new PrintWriter("writer.txt");
    pWriter.append("测试");
    pWriter.close();

    FileOutputStream fos = new FileOutputStream(FileDescriptor.out);

    PrintStream err = new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.err)),true,"gbk");

//    fos.write("测试标准输出");
//    err.println("测试标准错误");
  }
}