package chap04.sect04;
import java.util.Arrays;
public class ConvertCheck {
	public static void main(String[] args) throws Exception {
		byte[] bs = { -128, 2};   // (byte)0x81, (byte)0x02
		System.out.println( String.format( "%11s", "INIT VALUE ") + Arrays.toString(bs)); 

		byte[] bytes = new String(bs, "ISO-8859-1").getBytes("ISO-8859-1");
		System.out.println( String.format("%11s", "ISO-8859-1 ") + Arrays.toString(bytes)); 

		bytes = new String(bs, "GBK").getBytes("GBK");
		System.out.println( String.format( "%11s", "GBK ") + Arrays.toString(bytes)); 

		bytes = new String(bs, "GB2312").getBytes("GB2312");
		System.out.println( String.format( "%11s", "GB2312 ") + Arrays.toString(bytes)); 

		bytes = new String(bs, "UTF8").getBytes("UTF8");
		System.out.println(  String.format( "%11s", "UTF-8 ")  + Arrays.toString(bytes)); 

		bytes = new String(bs, "UTF16").getBytes("UTF_16be");
		System.out.println(  String.format( "%11s", "UTF-16 ") + Arrays.toString(bytes)); 
	}
}