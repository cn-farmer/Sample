package chap12;
	
import org.junit.Assert;
import org.junit.Test;

import chap12.MyClassLoader;

public class MyClassLoaderTest {

	@Test
	public void testFindClassString() throws ClassNotFoundException {
		MyClassLoader myClassLoader = new MyClassLoader(); 
		myClassLoader.findClass("chap12.IPasswordFacade");
		myClassLoader.findClass("chap12.IStudent");
		myClassLoader.findClass("chap12.Teacher");
		Class<?> findClass = myClassLoader.findClass("chap12.Student");
		if( findClass == null ) {
			Assert.fail("自定义类加载器执行失败！");
		}
	}
}
