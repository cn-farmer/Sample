package chap05.sect03;
import java.io.*;
public class MyOutStream extends DataOutputStream {
  OutputStream out;
  public MyOutStream(OutputStream out) {
    super(out);
    this.out = out;
  }
  public void writeint(int i) throws IOException {
    writeUTF(new Integer(i).toString());
  }

  public void writeboolean(boolean b) throws IOException {
    if (b == true) {
      writeUTF("True");
    } else {
      writeUTF("False");
    }
  }
}