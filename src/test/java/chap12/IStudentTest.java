package chap12;
	
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Method;
import java.util.Observer;

import org.junit.Test;

import chap12.IPasswordFacade;
import chap12.IStudent;

public class IStudentTest {

	@Test
	public void testClone() throws NoSuchMethodException, SecurityException{
		Method method = IStudent.class.getMethod("clone", (Class<?>[])null);
		assertNotNull("IStudent接口中没有定义clone方法！", method);
	}
	
	@Test
	public void testAddObserver() throws NoSuchMethodException, SecurityException{
		Method method = IStudent.class.getMethod("addObserver", Observer.class);
		assertNotNull("IStudent接口中没有定义addObserver方法！", method);
	}

	@Test
	public void testToStringMethod() throws NoSuchMethodException, SecurityException{
		Method method = IStudent.class.getMethod("toString", (Class<?>[])null);
		assertNotNull("IStudent接口中没有定义toString方法！",method);
	}
	
	@Test
	public void testSuperType() {
	  Class<?>[] ifs = IStudent.class.getInterfaces();
	  assertEquals("IStudent接口没有实现IPasswordFacade接口！",IPasswordFacade.class, ifs[0]);
	}
}