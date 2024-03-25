package temp;

import java.util.HashMap;

public class T1 {
  static final public void main(String[] args) throws Exception {
    HashMap<Object,Object> hashMap = new HashMap<>();
    hashMap.put(1, "aa");
    hashMap.put(2, "bb");
    
    String s = "32323.99";
    s= s.replace(",","" );
    System.out.println(s);
  }
}