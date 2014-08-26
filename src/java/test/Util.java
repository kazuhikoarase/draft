package test;

public class Util {

	private Util() {
	}
	
	public static void measure(Runnable r) {
//		long limit = 1_000_000_000L;
		long limit = 500_000_000L;
		long loops = 1;
		boolean capture = false;
		int measureCount = 0;
		long sum = 0;
		
		while (measureCount < 10) {
			
			long start = System.nanoTime();
			for (int i = 0; i < loops; i += 1) {
				r.run();
			}
			long ellapse = System.nanoTime() - start;

			if (capture) {
			} else if (ellapse > limit) {
				capture = true;
			} else {
				loops <<= 1;
				continue;
			}

			sum += ellapse;
			measureCount += 1;
		}
		
		// result
		double execTimeInNanos = 1.0 * sum / measureCount / loops;
		System.out.printf("%8.2f nanos\n", execTimeInNanos);
	}
}