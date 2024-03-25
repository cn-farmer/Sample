package chap12;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import chap12.MyProxy;
 
public class MyProxyTest {

	@Test
	public void testProxy(){
		@SuppressWarnings("unchecked")
		Map<Integer,String> map = (Map<Integer,String>) MyProxy.factory(new HashMap<Integer, String>());
		map.put(1, "First");
		String s = map.get(1);
		Assert.assertEquals("动态代理功能错误！", "First", s );
	}
}