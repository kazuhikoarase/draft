
package test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.Test;

@Target(ElementType.LOCAL_VARIABLE) @Retention(RetentionPolicy.RUNTIME)
@interface LocalVar {}

@Target(ElementType.TYPE_USE) @Retention(RetentionPolicy.RUNTIME)
@interface TypeUse {}

@Target(ElementType.TYPE_PARAMETER) @Retention(RetentionPolicy.RUNTIME)
@interface TypeParam {}

@Target(ElementType.PARAMETER) @Retention(RetentionPolicy.RUNTIME)
@interface Param {}


class MyClass<@TypeParam T> {}

public class Test2 {

	@Test
	public void annot() {
		@LocalVar @TypeUse String a = "TEST";
		MyClass<String> b;
		MyClass<@TypeUse String> c;
	}

	public <T> void test(@Param @TypeUse T  a) {
		
	}
}
