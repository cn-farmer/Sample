package chap04.sect05;

public class CharacterInMemTest {

	public static void main(String[] args) throws Exception {
	  char c1 = 'A';
	  char c2 = '丂';
	  String string2 = "丂";
//	  char c3 = '𠀄';
//	  Character c4 = new Character( '𠀄' );
	  char[] chars1 = Character.toChars(0x2_00_04);

//	  char[] chars1 = Character.toChars(0x2_00_04);
	  char[] chars2 = "𠀄".toCharArray();
	  String string = new String(chars1);

	  System.out.println(chars1 );
	  System.out.println(chars2 );
	}
}