package chap07.sect05;

import java.util.concurrent.ConcurrentHashMap;
  
public class ConCurrentHashMapTest {
  public static void main(String[] args) {
    ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
    
    map.put("1",0);
    map.put("2",4);
    map.put("3",6);
    map.put("4",8);
    // 1. 返回使用给定的reducer组合值来累积所有（键，值）对的给定转换的结果，如果没有，则返回null
    String res =  map.reduce(5,(key,value)->{
        System.out.println("transformer key:"+key+" value:"+value);
        return value+"";
    },(key,value)->{
        System.out.println("reducer key:"+key+" value:"+value);
        return key+value+"";
    });
    System.out.println("res:"+res);
  }
}
