package chap05.sect02;

import java.io.ByteArrayInputStream;

public class MyInStream extends ByteArrayInputStream {
  public MyInStream(byte[] buf) {
    super(buf);
  }

  public String readBySplit(char split) {
    int content;
    int len = 0;
    byte[] bs = new byte[100];
    while (-1 != (content = read())) {
        if( split == (char)content ) {
        break;
      }
      bs[len++] = (byte) content;
    }
    return (len > 0) ? new String(bs, 0, len) : null;
  }
}