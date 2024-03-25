package temp;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        // 创建一个示例 ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("记录1");
        arrayList.add("记录2");
        List<String> arrayList2 = new ArrayList<>();
        arrayList2.add("记录3");
        arrayList2.add("记录4");
        arrayList2.add("记录5");
        arrayList2.add("记录6");
        arrayList2.add("记录7");
        List<String> arrayList3 = new ArrayList<>();
        arrayList3.add("记录8");
        arrayList3.add("记录9");
        arrayList3.add("记录10");

        List<String> arrayList4 = new ArrayList<>();
        List<String> arrayList5 = new ArrayList<>();

        arrayList4.addAll(arrayList);
//        arrayList4.addAll(null);
        arrayList4.addAll(arrayList3);
        arrayList4.addAll(arrayList5);
        
        System.out.println(arrayList4);
    }
}