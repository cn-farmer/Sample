package chap12;
	
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
 
@RunWith(Suite.class)
@SuiteClasses({ 
	MyRuntimeExceptionTest.class,
	MyAnnotationTest.class, 
	MyLogTest.class,
	MyProxyTest.class,
	TeacherTest.class,
	IStudentTest.class, 
	StudentTest.class, 
	MyDescStrategyTest.class,
	SendInfoRunnableTest.class,
	ClientMainTest.class,
	ReceiveInfoCallableTest.class,
	ServerMainTest.class
})
public class AllTests {
}