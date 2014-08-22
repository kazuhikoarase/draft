
package test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandleProxies;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Test1 {
	
	@Test
	public void lambda1() {
		List<String> l = Arrays.asList("a", "b");
		Collections.sort(l, (o1, o2) -> o1.compareTo(o2) );
	}
	
	@Test
	public void lambda2() {
		List<String> l = Arrays.asList("a", "b");
		Collections.sort(l, Test1::compare);
	}
	
	private static int compare(String s1, String s2) {
		return s1.compareTo(s2);
	}
	
	@Test
	public void lambda3() {
		int a = 2;
		List<String> l = Arrays.asList("a", "b");
		Collections.sort(l, (o1, o2) -> {
			Assert.assertEquals(2, a);
			return o1.compareTo(o2);
		} );
	}

	@Test
	public void lambda4() throws Exception {
		int a = 2;
		MethodHandle mh = MethodHandles.lookup().
				findStatic(Test1.class, "method",
				MethodType.methodType(int.class, 
						int.class, String.class, String.class) );
		mh = MethodHandles.insertArguments(mh, 0, a);
		List<String> l = Arrays.asList("a", "b");
		Collections.sort(l, (Comparator<String>)MethodHandleProxies.
				asInterfaceInstance(Comparator.class, mh) );
	}
	
	private static int method(int a, String s1, String s2) {
		Assert.assertEquals(2, a);
		return s1.compareTo(s2);
	}
	
}
