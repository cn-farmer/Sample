package chap12;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Observable;
import java.util.Observer;

import org.junit.Before;
import org.junit.Test;

import chap12.IStudent;
import chap12.MyRuntimeException;
import chap12.Student;

public class StudentTest {

	public static String msg;
	public IStudent<Number> student;

	@Before
	public void setUp() throws Exception {
		student = new Student<Number>(1, "小明", "123456");
	}

	@Test
	public void testGetPassword() {
		student.addObserver(new Observer() {
			public void update(Observable o, Object arg) {
				msg = "observer invoked";
			}
		});
		student.getPassword();
		assertEquals("观察者模式未触发！", "observer invoked", msg);
	}

	@Test(expected = MyRuntimeException.class)
	public void testSetPassword() {
		student.setPassword("123");
	}

	@Test
	public void testToString() {
		student = new Student<Number>(1, "小明", "1234");
		String str = student.toString();
		assertTrue("toString错误！", str.contains("\nStudent [id=1, name=小明, password=1234, teacher=Teacher"));
	}

	@Test
	public void testDeepClone() throws CloneNotSupportedException {
		@SuppressWarnings("unchecked")
		IStudent<Number> c = (IStudent<Number>) student.clone();
		assertNotEquals("深克隆验证失败！", c.getTeacher().hashCode(), student.getTeacher().hashCode());
	}
}