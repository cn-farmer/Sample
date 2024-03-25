package temp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class t4 {

  public static void main(String[] args) {
    Date date = new Date(2023, 10, 11, 0, 13, 14);
    SimpleDateFormat sdFormat = new SimpleDateFormat(" a hh:mm:ss ");
    String format = sdFormat.format(date);
    System.out.println(format);
  }
}
