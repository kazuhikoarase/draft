
package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Test1 {
	
	@Test
	public void java8() {
		List<String> list = Arrays.asList("a", "b");
		Collections.sort(list, (s1, s2) -> 0);
	}
}