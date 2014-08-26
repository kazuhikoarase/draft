package test;

import java.io.IOException;
import java.io.InputStream;

public interface ReadBytes {
	void apply(byte[] b, int length);
	static void readBytes(InputStream in, ReadBytes readBytes)
	throws IOException {
		int len;
		byte[] b = new byte[4096];
		while ( (len = in.read(b) ) != -1) {
			readBytes.apply(b, len);
		}
	}
}