package chap11;
	
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import chap11.sect02.JUnit4CalculatorTest;
 
@RunWith(Suite.class)
@SuiteClasses({ 
	JUnit4CalculatorTest.class, 
})
public class AllTestJUnit4 {

}