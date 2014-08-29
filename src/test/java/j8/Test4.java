package j8;

import java.util.Random;

import org.junit.Test;

public class Test4 {

	@Test
	public void measure1() {

		Random r = new Random();
		Util.measure(()->{
			int i = (int)r.nextDouble();
		});
		Util.measure(()->{
			int i = (int)Math.floor(r.nextDouble() );
		});
		Util.measure(()->{
		});
		Util.measure(new Runnable() {
			public void run() {
			}
		} );
	}

	@Test
	public void measure2() {
		Util.measure(()->{
		});
		Util.measure(new Runnable() {
			public void run() {
			}
		} );
	}
}
