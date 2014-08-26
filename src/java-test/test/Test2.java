package test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.Test;

public class Test2 {

	@Target(ElementType.LOCAL_VARIABLE) @Retention(RetentionPolicy.RUNTIME)
	public @interface LocalVar {}

	@Target(ElementType.TYPE_USE) @Retention(RetentionPolicy.RUNTIME)
	public @interface TypeUse {}

	@Target(ElementType.TYPE_PARAMETER) @Retention(RetentionPolicy.RUNTIME)
	public @interface TypeParam {}

	@Target(ElementType.PARAMETER) @Retention(RetentionPolicy.RUNTIME)
	public @interface Param {}


	public static class MyClass<@TypeParam T> {}

	@Test
	public void annot() {
		@LocalVar @TypeUse String a = "TEST";
		MyClass<String> b;
		MyClass<@TypeUse String> c;
	}

	public <T> void test(@Param @TypeUse T  a) {
		
	}
}
