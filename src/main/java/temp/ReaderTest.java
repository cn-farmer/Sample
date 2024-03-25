package temp;

import java.io.FileWriter;
import java.io.IOException;

public class ReaderTest {
  public static void main(String[] args) throws IOException {
    FileWriter fileWriter = new FileWriter("www.txt");
    fileWriter.write("hello");
    fileWriter.flush();
  }
}
