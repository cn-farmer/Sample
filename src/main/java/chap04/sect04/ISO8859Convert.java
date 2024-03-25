package chap04.sect04;

/**
 * 1 copy String from c1
 * 2 turn C2.java to iso-8859-1 
 * so. the string must turn to utf-8, then turn from gbk to utf-8
 */
public class ISO8859Convert {
	public static void main(String[] args) throws Exception {
		String s = "浣犲ソ";
		String s2 = new String(s.getBytes("iso-8859-1"),"utf-8");
		String s3 = new String(s2.getBytes("gbk"),"utf-8");
		
		System.out.println(s3);
	}
}