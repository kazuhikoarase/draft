package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Function;

public class Test3 {

	public void test() throws IOException {

//		Function<String,Integer> f1 = MyClass::length;
		Function<MyClass,Integer> f2 = MyClass::length;
		Function<String,Integer> f3 = String::length;

		try (InputStream in = new FileInputStream("log") ) {
			ReadBytes.readBytes(in, (b, len) -> {
			});
		}

		try (BufferedReader in = new BufferedReader(
				new InputStreamReader(new FileInputStream("log"), "UTF-8") ) ) {
			in.lines().forEach((s)->{});
		}
	}
}
