package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test3 {

	public void test() throws Exception {

		Function<String,Integer> f1 = MyClass::length;
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
		
		List<MyClass> list = new ArrayList<>();
		append(list, MyClass.class);
		append(list, MyClass::new);
	}

	public void getterTest(Map<String,Object> map) throws Exception {
		func(map::get);
	}

	public void getterTest(ResultSet rs) throws Exception {
		func(rs::getObject);
	}

	public void func(PropertyGetter<String,?> getter) throws Exception {
		getter.get("");
	}

	public <T> void append(List<T> list, Class<T> clazz) throws Exception {
		list.add(clazz.newInstance() );
	}

	public <T> void append(List<T> list, Supplier<T> factory) throws Exception {
		list.add(factory.get() );
	}
}
