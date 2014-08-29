package j8;

@FunctionalInterface
public interface PropertyGetter<K, V> {
	V get(K key) throws Exception;
}
