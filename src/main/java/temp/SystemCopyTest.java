package temp;

import java.util.Arrays;

public class SystemCopyTest {
	public static void main(String[] args) {
		char[] array = new char[10];
		array[0] = 'a';
		array[1] = 'b';
		array[2] = 'c';
		array[3] = 'd';
		array[4] = 'e';
		array[5] = 'f';
		System.out.println( Arrays.toString(array));
		System.arraycopy(array, 2, array, 0, 8);
		System.out.println( Arrays.toString(array));
	}
}